package com.fr24.repository.di

import com.fr24.domain.repository.FlightDataRepository
import com.fr24.repository.repositories.FlightDataRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModuleImplementation {

    @Binds
    abstract fun bindsFlightDataRepository(
        flightDataRepositoryImpl: FlightDataRepositoryImpl
    ): FlightDataRepository
}