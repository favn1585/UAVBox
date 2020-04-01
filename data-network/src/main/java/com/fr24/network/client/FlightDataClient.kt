package com.fr24.network.client

import com.fr24.network.model.entity.FlightDataDto
import io.reactivex.Single
import retrofit2.http.GET

interface FlightDataClient {
    @GET("/ios-coding-challenge/ios-test-data.json")
    fun loadFlightData(): Single<FlightDataDto>
}