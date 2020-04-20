package com.uav.box.common.android.mvvm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.uav.box.common.android.BaseViewModel
import com.uav.box.common.android.navigation.Dispatcher
import javax.inject.Inject

/**
 * Base MVVM activity. This class should be used as a base for every activity in the application
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding>(
    @param:LayoutRes private val layoutResId: Int,
    private val viewModelClass: Class<VM>
) : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: GenericViewModelFactory<VM>

    @Inject
    lateinit var dispatcher: Dispatcher

    private val postOnResumeActions = mutableListOf<() -> Unit>()

    private lateinit var binding: DB
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(viewModelClass)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        onBind(binding)
    }

    override fun onResume() {
        super.onResume()
        viewModel.start()
    }

    override fun onPause() {
        super.onPause()
        viewModel.stop()
    }

    @CallSuper
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        postOnResumeActions.add {
            when (resultCode) {
                Activity.RESULT_CANCELED -> dispatcher.onResult(requestCode, false, data)
                Activity.RESULT_OK -> dispatcher.onResult(requestCode, true, data)
            }
        }
    }

    protected abstract fun inject()

    protected abstract fun onCreateViewModel(): VM

    protected abstract fun onBind(binding: DB)
}
