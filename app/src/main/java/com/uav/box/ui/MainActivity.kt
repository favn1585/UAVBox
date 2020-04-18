package com.uav.box.ui

import androidx.activity.viewModels
import com.uav.box.R
import com.uav.box.app.App
import com.uav.box.common.android.mvvm.BaseActivity
import com.uav.box.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(
    R.layout.activity_main,
    MainActivityViewModel::class.java
) {
    override fun inject() {
        (applicationContext as App).component.inject(this)
    }

    override fun onCreateViewModel(): MainActivityViewModel {
        val viewModel: MainActivityViewModel by viewModels()
        return viewModel
    }

    override fun onBind(binding: ActivityMainBinding) {
        binding.viewModel = viewModel
    }
}
