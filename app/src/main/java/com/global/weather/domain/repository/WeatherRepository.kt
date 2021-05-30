package com.global.weather.domain.repository

import com.global.weather.data.remote.model.WeatherApiModel
import io.reactivex.Observable

internal interface WeatherRepository {
    fun getWeather(latitude: Double, longitude: Double): Observable<WeatherApiModel>
}
