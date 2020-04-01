package com.fr24.network.networkRepositories

import com.fr24.domain.entity.FlightData
import com.fr24.network.client.FlightDataClient
import com.fr24.network.networkRepositories.mappers.FlightDataDtoMapper
import io.reactivex.Single
import javax.inject.Inject

class FlightDataNetworkRepository @Inject constructor(
    private val flightDataDtoMapper: FlightDataDtoMapper,
    private val flightDataClient: FlightDataClient
) {
    fun loadFlightData(): Single<FlightData> {
        return flightDataClient.loadFlightData()
            .map { flightData ->
                flightDataDtoMapper.map(flightData)
            }
    }
}