package com.uav.box.network.model.entity

import com.google.gson.annotations.SerializedName

data class FlightDataDto(
    @SerializedName("full_count")
    val count: Long,

    @SerializedName("version")
    val version: Int,

    @SerializedName("copyright")
    val copyright: String,

    @SerializedName("aircraft")
    val flights: List<FlightDto>
)


