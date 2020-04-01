package com.fr24.network.di

import com.fr24.network.client.FlightDataClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideFlightDataClient(retrofit: Retrofit): FlightDataClient {
        return retrofit.create(FlightDataClient::class.java)
    }

    companion object {
        const val BASE_URL = "https://s3.amazonaws.com"
    }
}