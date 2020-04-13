package com.uav.box.repository.di

import com.uav.box.domain.repository.FlightDataRepository
import com.uav.box.repository.repositories.FlightDataRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModuleImplementation {

    @Binds
    abstract fun bindsFlightDataRepository(
        flightDataRepositoryImpl: FlightDataRepositoryImpl
    ): FlightDataRepository
}