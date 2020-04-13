package com.uav.box.network.networkRepositories.mappers

import com.uav.box.domain.entity.FlightData
import com.uav.box.domain.mapper.Mapper
import com.uav.box.domain.mapper.mapAll
import com.uav.box.network.model.entity.FlightDataDto
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