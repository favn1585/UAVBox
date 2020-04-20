package com.uav.box.domain.entity

/**
 * Map bounds object. Class that contains map are
 * @param coordinate1 is a left top location of mab bounds
 * @param coordinate2 is a bottom right location of mab bounds
 */
data class MapBounds(
    val coordinate1: Coordinate,
    val coordinate2: Coordinate
)