package com.uav.box.utils

import javax.inject.Inject
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

class CoordinateUtils @Inject constructor() {

    /**
     * Get distance between 2 coordinates
     * Take from here: https://www.geodatasource.com/developers/java
     */
    fun getDistance(
        lat1: Float,
        lon1: Float,
        lat2: Float,
        lon2: Float
    ): Float {
        val theta = lon1 - lon2
        var dist =
            sin(Math.toRadians(lat1.toDouble())) * sin(
                Math.toRadians(lat2.toDouble())
            ) + cos(Math.toRadians(lat1.toDouble())) * cos(
                Math.toRadians(lat2.toDouble())
            ) * cos(Math.toRadians(theta.toDouble()))
        dist = acos(dist)
        dist = Math.toDegrees(dist)
        return (dist * 60 * 1.1515).toFloat()
    }
}