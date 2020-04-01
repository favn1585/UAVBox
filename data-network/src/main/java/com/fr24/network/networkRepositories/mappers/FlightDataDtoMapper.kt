package com.fr24.network.networkRepositories.mappers

import com.fr24.domain.entity.Flight
import com.fr24.domain.entity.FlightData
import com.fr24.domain.mapper.Mapper
import com.fr24.domain.mapper.mapAll
import com.fr24.network.model.entity.FlightDataDto
import com.fr24.network.model.entity.FlightDto
import javax.inject.Inject

class FlightDataDtoMapper @Inject constructor(
    val flightDtoMapper: FlightDtoMapper
) : Mapper<FlightDataDto, FlightData> {

    override fun map(from: FlightDataDto): FlightData {
        return with(from) {
            FlightData(
                count = count,
                version = version,
                copyright = copyright,
                flights = flightDtoMapper.mapAll(flights)
            )
        }
    }
}