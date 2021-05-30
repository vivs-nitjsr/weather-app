package com.global.weather.data.remote.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

internal class WeatherReportApiModel(
    @SerializedName("time")
    val time: Long,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("temperature")
    val temperature: Float?,
    @SerializedName("apparentTemperature")
    val apparentTemperature: Float?,
    @SerializedName("dewPoint")
    val dewPoint: Float,
    @SerializedName("humidity")
    val humidity: Float,
    @SerializedName("pressure")
    val pressure: Float,
    @SerializedName("windSpeed")
    val windSpeed: Float,
    @SerializedName("windGust")
    val windGust: Float,
    @SerializedName("windBearing")
    val windBearing: Float,
    @SerializedName("cloudCover")
    val cloudCover: Float,
    @SerializedName("uvIndex")
    val uvIndex: Int,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("ozone")
    val ozone: Float,
    @SerializedName("precipIntensity")
    val precipIntensity: Float,
    @SerializedName("precipProbability")
    val precipProbability: Float,
    @SerializedName("sunriseTime")
    val sunriseTime: Long?,
    @SerializedName("sunsetTime")
    val sunsetTime: Long?,
    @SerializedName("moonPhase")
    val moonPhase: Float?,
    @SerializedName("precipIntensityMax")
    val precipIntensityMax: Float?,
    @SerializedName("precipIntensityMaxTime")
    val precipIntensityMaxTime: Long?,
    @SerializedName("precipType")
    val precipType: String?,
    @SerializedName("temperatureHigh")
    val temperatureHigh: Float?,
    @SerializedName("temperatureHighTime")
    val temperatureHighTime: Long?,
    @SerializedName("temperatureLow")
    val temperatureLow: Float?,
    @SerializedName("temperatureLowTime")
    val temperatureLowTime: Long?,
    @SerializedName("apparentTemperatureHigh")
    val apparentTemperatureHigh: Float?,
    @SerializedName("apparentTemperatureHighTime")
    val apparentTemperatureHighTime: Long?,
    @SerializedName("apparentTemperatureLow")
    val apparentTemperatureLow: Float?,
    @SerializedName("apparentTemperatureLowTime")
    val apparentTemperatureLowTime: Long?,
    @SerializedName("windGustTime")
    val windGustTime: Long?,
    @SerializedName("uvIndexTime")
    val uvIndexTime: Long?,
    @SerializedName("temperatureMin")
    val temperatureMin: Float?,
    @SerializedName("temperatureMinTime")
    val temperatureMinTime: Long?,
    @SerializedName("temperatureMax")
    val temperatureMax: Float?,
    @SerializedName("temperatureMaxTime")
    val temperatureMaxTime: Long?,
    @SerializedName("apparentTemperatureMin")
    val apparentTemperatureMin: Float?,
    @SerializedName("apparentTemperatureMinTime")
    val apparentTemperatureMinTime: Long?,
    @SerializedName("apparentTemperatureMax")
    val apparentTemperatureMax: Float?,
    @SerializedName("apparentTemperatureMaxTime")
    val apparentTemperatureMaxTime: Long?
) : Serializable
