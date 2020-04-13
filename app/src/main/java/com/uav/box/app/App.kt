package com.uav.box.app

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.uav.box.di.AppComponent
import com.uav.box.di.DaggerAppComponent

class App : MultiDexApplication() {

    lateinit var component: AppComponent
    lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        component = DaggerAppComponent.builder().build()
    }
}