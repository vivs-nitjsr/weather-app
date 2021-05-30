package com.global.weather.data.remote.repository

import android.app.Application
import com.global.weather.commons.AssetFileLoader
import com.global.weather.commons.JsonParser
import com.global.weather.data.remote.api.WeatherApi
import com.global.weather.data.remote.model.WeatherApiModel
import com.global.weather.domain.repository.WeatherRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

internal class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val app: Application,
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
