package com.uav.box.di

import com.uav.box.network.di.NetworkModule
import com.uav.box.repository.di.RepositoryModuleImplementation
import com.uav.box.ui.MainActivity
import com.uav.box.app.App
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        NetworkModule::class,
        RepositoryModuleImplementation::class,
        SchedulerModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)
    fun inject(answersPresenter: MainActivity)
}