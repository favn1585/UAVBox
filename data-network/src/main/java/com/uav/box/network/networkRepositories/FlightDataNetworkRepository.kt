package com.uav.box.network.networkRepositories

import com.uav.box.domain.entity.FlightData
import com.uav.box.network.client.FlightDataClient
import com.uav.box.network.networkRepositories.mappers.FlightDataDtoMapper
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