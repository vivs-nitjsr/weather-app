package com.global.weather.data.remote.repository

import com.global.weather.data.remote.api.WeatherApi
import com.global.weather.data.remote.model.WeatherApiModel
import com.global.weather.domain.repository.WeatherRepository
import io.reactivex.rxjava3.core.Observable

internal class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi,
) : WeatherRepository {
    override fun getWeather(latitude: Double, longitude: Double): Observable<WeatherApiModel> {
        return weatherApi.getWeather(
            latitude = latitude,
            longitude = longitude
        )
    }
}
