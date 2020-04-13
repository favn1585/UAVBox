package com.uav.box.network.networkRepositories.mappers

import com.uav.box.domain.entity.Flight
import com.uav.box.domain.mapper.Mapper
import com.uav.box.network.model.entity.FlightDto
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