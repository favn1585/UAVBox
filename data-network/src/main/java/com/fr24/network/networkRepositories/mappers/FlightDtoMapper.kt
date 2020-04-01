package com.fr24.network.networkRepositories.mappers

import com.fr24.domain.entity.Flight
import com.fr24.domain.mapper.Mapper
import com.fr24.network.model.entity.FlightDto
import javax.inject.Inject

class FlightDtoMapper @Inject constructor() : Mapper<FlightDto, Flight> {

    override fun map(from: FlightDto): Flight {
        return with(from) {
            Flight(
                id = id,
                aircraftId = aircraftId,
                latitude = latitude,
                longitude = longitude,
                track = track,
                speed = speed,
                squawk = squawk,
                radarName = radarName,
                model = model,
                registration = registration,
                timeStamp = timeStamp,
                from = this.from,
                to = to,
                number = number,
                landed = landed,
                verticalSpeed = verticalSpeed,
                callSign = callSign
            )
        }
    }
}