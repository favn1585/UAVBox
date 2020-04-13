package com.uav.box.di

import com.uav.box.domain.rx.SchedulersProvider
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

/**
 * Main Schedulers module
 */
@Module
class SchedulerModule {

    @Singleton
    @Provides
    fun provideSchedulersProvider(): SchedulersProvider = object : SchedulersProvider {
        @Provides
        override fun io() = Schedulers.io()

        @Provides
        override fun computation() = Schedulers.computation()

        @Provides
        override fun ui() = AndroidSchedulers.mainThread()
    }
}