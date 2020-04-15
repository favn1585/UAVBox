package com.uav.box.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.uav.box.R
import com.uav.box.app.App
import com.uav.box.databinding.ActivityMainBinding
import com.uav.box.domain.entity.Flight
import com.uav.box.utils.CoordinateUtils
import com.uav.box.domain.entity.FlightData
import com.uav.box.domain.repository.FlightDataRepository
import com.uav.box.domain.rx.SchedulersProvider
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var flightDataRepository: FlightDataRepository

    @Inject
    lateinit var schedulersProvider: SchedulersProvider

    @Inject
    lateinit var coordinateUtils: CoordinateUtils

    private var flightData: FlightData? = null

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (applicationContext as App).component.inject(this)

        compositeDisposable.add(flightDataRepository.getFlightData()
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())
            .subscribe { flightData ->
                this.flightData = flightData
                calcFarthestPlanes()
            })
    }

    private fun calcFarthestPlanes() {
        compositeDisposable.add(Single.fromCallable {
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
                binding.tvFarthestPlanes.text = text
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
