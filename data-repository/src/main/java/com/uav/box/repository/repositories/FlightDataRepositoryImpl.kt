package com.uav.box.repository.repositories

import com.uav.box.domain.entity.FlightData
import com.uav.box.domain.repository.FlightDataRepository
import com.uav.box.network.networkRepositories.FlightDataNetworkRepository
import io.reactivex.Single
import javax.inject.Inject

class FlightDataRepositoryImpl @Inject constructor(
    private val flightDataNetworkRepository: FlightDataNetworkRepository
) : FlightDataRepository {

    override fun getFlightData(): Single<FlightData> {
        return flightDataNetworkRepository.loadFlightData()
    }
}