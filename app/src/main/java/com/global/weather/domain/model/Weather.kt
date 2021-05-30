package com.global.weather.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
internal data class Weather(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val currentWeather: WeatherReport,
    val hourlyWeatherReport: WeatherReportList,
    val dailyWeatherReport: WeatherReportList
) : Parcelable
