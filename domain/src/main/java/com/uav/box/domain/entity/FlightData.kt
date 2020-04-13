package com.uav.box.domain.entity

data class FlightData(
    val count: Long,
    val version: Int,
    val copyright: String,
    val flights: List<Flight>
)


