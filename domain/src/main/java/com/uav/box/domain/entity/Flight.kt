package com.uav.box.domain.entity

data class Flight(
    val id: String,
    val aircraftId: String,
    val latitude: Float,
    val longitude: Float,
    val track: Int,
    val speed: Int,
    val squawk: Int,
    val radarName: String,
    val model: String,
    val registration: String,
    val timeStamp: Long,
    val from: String,
    val to: String,
    val number: String,
    val landed: Int,
    val verticalSpeed: Int,
    val callSign: String
)