package com.fr24.routecalculator.app

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.fr24.routecalculator.di.AppComponent
import com.fr24.routecalculator.di.DaggerAppComponent

class App : MultiDexApplication() {

    lateinit var component: AppComponent
    lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        component = DaggerAppComponent.builder().build()
    }
}