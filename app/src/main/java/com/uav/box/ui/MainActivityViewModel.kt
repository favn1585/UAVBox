package com.uav.box.ui

import androidx.databinding.Bindable
import com.uav.box.BR
import com.uav.box.common.android.BaseViewModel
import com.uav.box.domain.entity.Flight
import com.uav.box.domain.entity.FlightData
import com.uav.box.domain.repository.FlightDataRepository
import com.uav.box.domain.rx.SchedulersProvider
import com.uav.box.utils.CoordinateUtils
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    flightDataRepository: FlightDataRepository,
    private val schedulersProvider: SchedulersProvider,
    private val coordinateUtils: CoordinateUtils
) : BaseViewModel() {

    @get:Bindable
    var title: String by observable("", BR.title)

    private var flightData: FlightData? = null

    init {
        runOnStartup {
            flightDataRepository.getFlightData()
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribeBy(
                    onSuccess = { flightData ->
                        this.flightData = flightData
                        calcFarthestPlanes()
                    },
                    onError = {
                        // Timber.e...
                    }).autoDispose()
        }
    }

    private fun calcFarthestPlanes() {
        Single.fromCallable {
            flightData?.let { flightData ->
                var biggestDistance = 0f
                var flight0: Flight? = null
                var flight1: Flight? = null

                for (i in flightData.flights.indices) {
                    val flightToCompare: Flight = flightData.flights[i]
                    for (j in i until flightData.flights.size) {
                        val flight = flightData.flights[j]
                        val dist = coordinateUtils.getDistance(
                            flightToCompare.latitude,
                            flightToCompare.longitude,
                            flight.latitude,
                            flight.longitude
                        )
                        if (dist > biggestDistance) {
                            flight0 = flightToCompare
                            flight1 = flight
                            biggestDistance = dist
                        }
                    }
                }

                return@fromCallable "${flight0?.callSign} and ${flight1?.callSign} " +
                        "has the biggest distance of $biggestDistance[miles]"
            }
        }
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())
            .subscribe { text ->
                title = text!!
            }.autoDispose()
    }
}