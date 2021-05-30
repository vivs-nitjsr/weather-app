package com.global.weather.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class WeatherReport(
    val time: Long,
    val summary: String,
    val icon: String,
    val temperature: Double? = null,
    val apparentTemperature: Double? = null,
    val dewPoint: Double,
    val humidity: Double,
    val pressure: Double,
    val windSpeed: Double,
    val windGust: Double,
    val windBearing: Double,
    val cloudCover: Double,
    val uvIndex: Int,
    val visibility: Int,
    val ozone: Double,
    val precipIntensity: Double,
    val precipProbability: Double,
    val sunriseTime: Long? = null,
    val sunsetTime: Long? = null,
    val moonPhase: Double? = null,
    val precipIntensityMax: Double? = null,
    val precipIntensityMaxTime: Long? = null,
    val precipType: String? = null,
    val temperatureHigh: Double? = null,
    val temperatureHighTime: Long? = null,
    val temperatureLow: Double? = null,
    val temperatureLowTime: Long? = null,
    val apparentTemperatureHigh: Double? = null,
    val apparentTemperatureHighTime: Long? = null,
    val apparentTemperatureLow: Double? = null,
    val apparentTemperatureLowTime: Long? = null,
    val windGustTime: Long? = null,
    val uvIndexTime: Long? = null,
    val temperatureMin: Double? = null,
    val temperatureMinTime: Long? = null,
    val temperatureMax: Double? = null,
    val temperatureMaxTime: Long? = null,
    val apparentTemperatureMin: Double? = null,
    val apparentTemperatureMinTime: Long? = null,
    val apparentTemperatureMax: Double? = null,
    val apparentTemperatureMaxTime: Long? = null
) : Parcelable
