package com.uav.box.network.client

import com.uav.box.network.model.entity.FlightDataDto
import io.reactivex.Single
import retrofit2.http.GET

interface FlightDataClient {
    @GET("/favn1585/RouteCalculator/master/data.json")
    fun loadFlightData(): Single<FlightDataDto>
}