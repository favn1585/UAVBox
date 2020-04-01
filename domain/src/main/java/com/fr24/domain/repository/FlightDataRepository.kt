package com.fr24.domain.repository

import com.fr24.domain.entity.FlightData
import io.reactivex.Single

interface FlightDataRepository {
    fun getFlightData(): Single<FlightData>
}