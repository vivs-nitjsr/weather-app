package com.global.weather.data.remote.api

import com.global.weather.data.remote.model.WeatherApiModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

internal interface WeatherApi {
    @GET("/forecast/2bb07c3bece89caf533ac9a5d23d8417/{latitude},{longitude}")
    fun getWeather(
        @Path("latitude") latitude: Double,
        @Path("longitude") longitude: Double
    ): Observable<WeatherApiModel>
}
