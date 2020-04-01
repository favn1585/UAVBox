package com.fr24.routecalculator.di

import com.fr24.network.di.NetworkModule
import com.fr24.repository.di.RepositoryModuleImplementation
import com.fr24.routecalculator.MainActivity
import com.fr24.routecalculator.app.App
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