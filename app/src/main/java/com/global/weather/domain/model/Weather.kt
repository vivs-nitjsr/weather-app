package com.global.weather.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Weather(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val currentWeather: WeatherReport,
    val hourlyWeatherReportList: WeatherReportList,
    val dailyWeatherReportList: WeatherReportList
) : Parcelable
