package com.global.weather.data.remote.repository

import com.global.weather.commons.AssetFileLoader
import com.global.weather.commons.JsonParser
import com.global.weather.data.remote.api.WeatherApi
import com.global.weather.data.remote.model.WeatherApiModel
import com.global.weather.domain.repository.WeatherRepository
import com.global.weather.presentation.WeatherApplication
import io.reactivex.rxjava3.core.Observable

internal class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi,
    private val app: WeatherApplication,
    private val assetFileLoader: AssetFileLoader,
    private val jsonParser: JsonParser
) : WeatherRepository {

    companion object {
        const val IS_CACHED_RESPONSE = true
        const val WEATHER_JSON = "weather.json"
    }

    override fun getWeather(latitude: Double, longitude: Double): Observable<WeatherApiModel> {
        if (IS_CACHED_RESPONSE) {
            val jsonString = assetFileLoader.loadFileAsStream(app, WEATHER_JSON)
                .bufferedReader()
                .readText()
            val weatherApiModel = jsonParser.parse(jsonString, WeatherApiModel::class.java)

            return Observable.just(weatherApiModel)
        }

        return weatherApi.getWeather(
            latitude = latitude,
            longitude = longitude
        )
    }
}
