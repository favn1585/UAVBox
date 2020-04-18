package com.uav.box.common.android

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

typealias StartupAction = () -> Unit

open class BaseViewModel : ViewModel() {

    private val startupActions: MutableList<StartupAction> = mutableListOf()
    private val compositeDisposable = CompositeDisposable()

    private var started = false

    private val isFirstRun: Boolean
        get() {
            return !started
        }

    private val wasAlreadyStarted: Boolean
        get() {
            return started
        }

    override fun onCleared() {
        compositeDisposable.clear()
    }

    @CallSuper
    fun start() {
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

    fun Disposable.autoDispose() {
        compositeDisposable.add(this)
    }
}