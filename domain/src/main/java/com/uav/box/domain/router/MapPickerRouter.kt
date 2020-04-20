package com.uav.box.domain.router

import com.uav.box.domain.entity.MapBounds
import io.reactivex.Maybe

interface MapPickerRouter {
    fun pickMapBounds(): Maybe<MapBounds>
}