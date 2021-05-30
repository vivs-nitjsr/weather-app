package com.global.weather.data.remote.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

internal class WeatherApiModel(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("currently")
    val currentWeather: WeatherReportApiModel,
    @SerializedName("hourly")
    val hourlyWeatherReport: WeatherReportListApiModel,
    @SerializedName("daily")
    val dailyWeatherReport: WeatherReportListApiModel
) : Serializable
