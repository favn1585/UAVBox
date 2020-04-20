package com.uav.box.common.android

import android.os.Handler
import androidx.annotation.CallSuper
import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import com.uav.box.common.UnitAction
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.io.Closeable
import kotlin.properties.ObservableProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

typealias OnValueChange<T> = (T) -> Unit
typealias ShouldValueChange<T> = (old: T, new: T) -> Boolean
typealias StartupAction = () -> Unit

private typealias RxObservable<T> = io.reactivex.Observable<T>

open class BaseViewModel : ViewModel() {
    private val startupActions: MutableList<StartupAction> = mutableListOf()
    private var started = false

    private val isFirstRun: Boolean
        get() {
            return !started
        }

    private val wasAlreadyStarted: Boolean
        get() {
            return started
        }

    @CallSuper
    open fun start() {
        if (isFirstRun) {
            startupActions.forEach { action ->
                action()
            }
            started = true
        }
    }

    @CallSuper
    open fun stop() {
    }

    fun runOnStartup(action: StartupAction) {
        if (wasAlreadyStarted) {
            action()
        } else {
            startupActions.add(action)
        }
    }

    fun subscribeOnStartup(block: () -> Disposable) {
        runOnStartup {
            subscribe(block)
        }
    }
}

@Suppress("TooManyFunctions")
abstract class ViewModel : Observable, androidx.lifecycle.ViewModel(), Closeable {

    val compositeDisposable = CompositeDisposable()

    private val childViewModels = mutableListOf<ViewModel>()

    fun registerChildViewModel(viewModel: ViewModel) {
        childViewModels.add(viewModel)

        viewModel.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                notifyPropertyChanged(propertyId)
            }
        })
    }

    fun ViewModel.register() {
        this@ViewModel.registerChildViewModel(this)
    }

    @CallSuper
    override fun close() {
        compositeDisposable.clear()
    }

    @CallSuper
    override fun onCleared() {
        close()
        childViewModels.forEach {
            it.onCleared()
        }
        super.onCleared()
    }

    inline infix fun ViewModel.subscribe(crossinline block: () -> Disposable) {
        compositeDisposable.add(block())
    }

    fun Disposable.autoDispose() {
        compositeDisposable.add(this)
    }

    @Transient
    private var mCallbacks: PropertyChangeRegistry? = null

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        synchronized(this) {
            if (mCallbacks == null) {
                mCallbacks = PropertyChangeRegistry()
            }
        }
        mCallbacks!!.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        synchronized(this) {
            if (mCallbacks == null) {
                return
            }
        }
        mCallbacks!!.remove(callback)
    }

    /**
     * Notifies listeners that all properties of this instance have changed.
     */
    fun notifyChange() {
        synchronized(this) {
            if (mCallbacks == null) {
                return
            }
        }
        mCallbacks!!.notifyCallbacks(this, 0, null)
    }

    /**
     * Notifies listeners that a specific property has changed. The getter for the property
     * that changes should be marked with [Bindable] to generate a field in
     * `BR` to be used as `fieldId`.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    fun notifyPropertyChanged(fieldId: Int) {
        synchronized(this) {
            if (mCallbacks == null) {
                return
            }
        }
        mCallbacks!!.notifyCallbacks(this, fieldId, null)
    }

    /**
     * Extension method for creating kotlin delegated properties which automatically notify [BaseObservable] that
     * property value has changed
     */
    fun <T> BaseObservable.observable(
        initialValue: T,
        br: Int,
        onValueChange: OnValueChange<T> = {}
    ) = optionalObservable(
        initialValue = initialValue,
        br = br,
        onValueChange = onValueChange,
        shouldValueChange = { _, _ -> true }
    )

    /**
     * Extension method for creating kotlin delegated properties which automatically notify [BaseObservable] that
     * property value has changed
     */
    fun <T> BaseObservable.optionalObservable(
        initialValue: T, br: Int,
        onValueChange: OnValueChange<T> = {},
        shouldValueChange: ShouldValueChange<T>
    )
            : ReadWriteProperty<Any?, T> = object : ObservableProperty<T>(initialValue) {

        override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean {
            return shouldValueChange(oldValue, newValue)
        }

        override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) {
            if (oldValue != newValue) {
                this@optionalObservable.notifyPropertyChanged(br)
                onValueChange(newValue)
            }
        }
    }

    /**
     * Extension method for creating kotlin delegated properties which automatically notify [BaseViewModel] that
     * property value has changed
     */
    fun <T> BaseViewModel.observable(
        initialValue: T,
        br: Int,
        onValueChange: OnValueChange<T> = {}
    ) = optionalObservable(
        initialValue = initialValue,
        br = br,
        onValueChange = onValueChange,
        shouldValueChange = { _, _ -> true }
    )

    /**
     * Extension method for creating kotlin delegated properties which automatically notify [BaseViewModel] that
     * property value has changed
     */
    fun <T> BaseViewModel.optionalObservable(
        initialValue: T, br: Int,
        onValueChange: OnValueChange<T> = {},
        shouldValueChange: ShouldValueChange<T>
    )
            : ReadWriteProperty<Any?, T> = object : ObservableProperty<T>(initialValue) {

        override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean {
            val result = shouldValueChange(oldValue, newValue)
            if (!result) {
                notifyPropertyChanged(br)
            }

            return result
        }

        override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) {
            if (oldValue != newValue) {
                this@optionalObservable.notifyPropertyChanged(br)
                onValueChange(newValue)
            }
        }
    }

    /**
     * Extension method for changing data binding property changes into RxJava stream
     * It might seem to be small orienteering but thanks to that I was able to fast implement debounce when entering
     * query string. Of cource it could be implemented in other way but I didn't want to touch activity at all and have
     * there any logic.
     */
    fun <T> BaseViewModel.onChange(propertyId: Int, block: () -> T): RxObservable<T> {

        return RxObservable.create { emmiter ->

            val callback = object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, id: Int) {
                    if (propertyId == id) {
                        emmiter.onNext(block())
                    }
                }
            }

            emmiter.onNext(block())

            addOnPropertyChangedCallback(callback)

            emmiter.setCancellable {
                removeOnPropertyChangedCallback(callback)
            }
        }
    }
}

fun BaseViewModel.post(action: UnitAction) {
    Handler().post {
        action()
    }
}