package com.fr24.network.model.entity

import com.google.gson.annotations.SerializedName

data class FlightDto(
    @SerializedName("flight_id")
    val id: String,

    @SerializedName("aircraft_id")
    val aircraftId: String,

    @SerializedName("latitude")
    val latitude: Float,

    @SerializedName("longitude")
    val longitude: Float,

    @SerializedName("track")
    val track: Int,

    @SerializedName("speed")
    val speed: Int,

    @SerializedName("squawk")
    val squawk: Int,

    @SerializedName("radar_name")
    val radarName: String,

    @SerializedName("aircraft_model")
    val model: String,

    @SerializedName("aircraft_registration")
    val registration: String,

    @SerializedName("timestamp")
    val timeStamp: Long,

    @SerializedName("from_iata")
    val from: String,

    @SerializedName("to_iata")
    val to: String,

    @SerializedName("flight_number")
    val number: String,

    @SerializedName("on_ground")
    val landed: Int,

    @SerializedName("vertical_speed")
    val verticalSpeed: Int,

    @SerializedName("callsign")
    val callSign: String
)