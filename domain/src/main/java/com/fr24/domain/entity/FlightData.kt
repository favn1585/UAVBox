package com.fr24.domain.entity

data class FlightData(
    val count: Long,
    val version: Int,
    val copyright: String,
    val flights: List<Flight>
)


