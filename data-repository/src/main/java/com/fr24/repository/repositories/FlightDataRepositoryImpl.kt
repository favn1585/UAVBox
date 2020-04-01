package com.fr24.repository.repositories

import com.fr24.domain.entity.FlightData
import com.fr24.domain.repository.FlightDataRepository
import com.fr24.network.networkRepositories.FlightDataNetworkRepository
import io.reactivex.Single
import javax.inject.Inject

class FlightDataRepositoryImpl @Inject constructor(
    private val flightDataNetworkRepository: FlightDataNetworkRepository
) : FlightDataRepository {

    override fun getFlightData(): Single<FlightData> {
        return flightDataNetworkRepository.loadFlightData()
    }
}