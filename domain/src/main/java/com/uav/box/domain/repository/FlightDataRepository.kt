package com.uav.box.domain.repository

import com.uav.box.domain.entity.FlightData
import io.reactivex.Single

interface FlightDataRepository {
    fun getFlightData(): Single<FlightData>
}