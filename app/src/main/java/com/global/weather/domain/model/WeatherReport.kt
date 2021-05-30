package com.global.weather.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
internal data class WeatherReport(
    val time: Long,
    val summary: String,
    val icon: String,
    val temperature: Float? = null,
    val apparentTemperature: Float? = null,
    val dewPoint: Float,
    val humidity: Float,
    val pressure: Float,
    val windSpeed: Float,
    val windGust: Float,
    val windBearing: Float,
    val cloudCover: Float,
    val uvIndex: Int,
    val visibility: Int,
    val ozone: Float,
    val precipIntensity: Float,
    val precipProbability: Float,
    val sunriseTime: Long? = null,
    val sunsetTime: Long? = null,
    val moonPhase: Float? = null,
    val precipIntensityMax: Float? = null,
    val precipIntensityMaxTime: Long? = null,
    val precipType: String? = null,
    val temperatureHigh: Float? = null,
    val temperatureHighTime: Long? = null,
    val temperatureLow: Float? = null,
    val temperatureLowTime: Long? = null,
    val apparentTemperatureHigh: Float? = null,
    val apparentTemperatureHighTime: Long? = null,
    val apparentTemperatureLow: Float? = null,
    val apparentTemperatureLowTime: Long? = null,
    val windGustTime: Long? = null,
    val uvIndexTime: Long? = null,
    val temperatureMin: Float? = null,
    val temperatureMinTime: Long? = null,
    val temperatureMax: Float? = null,
    val temperatureMaxTime: Long? = null,
    val apparentTemperatureMin: Float? = null,
    val apparentTemperatureMinTime: Long? = null,
    val apparentTemperatureMax: Float? = null,
    val apparentTemperatureMaxTime: Long? = null
) : Parcelable
