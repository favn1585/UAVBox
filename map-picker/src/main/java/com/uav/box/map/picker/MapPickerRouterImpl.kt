package com.uav.box.map.picker

import com.uav.box.domain.entity.MapBounds
import com.uav.box.domain.router.MapPickerRouter
import io.reactivex.Maybe

class MapPickerRouterImpl: MapPickerRouter {

    override fun pickMapBounds(): Maybe<MapBounds> {
        PlacePicker.IntentBuilder()
    }

}