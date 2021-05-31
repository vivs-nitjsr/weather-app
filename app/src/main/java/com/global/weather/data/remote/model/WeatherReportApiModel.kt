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
    val temperature: Double?,
    @SerializedName("apparentTemperature")
    val apparentTemperature: Double?,
    @SerializedName("dewPoint")
    val dewPoint: Double,
    @SerializedName("humidity")
    val humidity: Double,
    @SerializedName("pressure")
    val pressure: Double,
    @SerializedName("windSpeed")
    val windSpeed: Double,
    @SerializedName("windGust")
    val windGust: Double,
    @SerializedName("windBearing")
    val windBearing: Double,
    @SerializedName("cloudCover")
    val cloudCover: Double,
    @SerializedName("uvIndex")
    val uvIndex: Double,
    @SerializedName("visibility")
    val visibility: Double,
    @SerializedName("ozone")
    val ozone: Double,
    @SerializedName("precipIntensity")
    val precipIntensity: Double,
    @SerializedName("precipProbability")
    val precipProbability: Double,
    @SerializedName("sunriseTime")
    val sunriseTime: Long?,
    @SerializedName("sunsetTime")
    val sunsetTime: Long?,
    @SerializedName("moonPhase")
    val moonPhase: Double?,
    @SerializedName("precipIntensityMax")
    val precipIntensityMax: Double?,
    @SerializedName("precipIntensityMaxTime")
    val precipIntensityMaxTime: Long?,
    @SerializedName("precipType")
    val precipType: String?,
    @SerializedName("temperatureHigh")
    val temperatureHigh: Double?,
    @SerializedName("temperatureHighTime")
    val temperatureHighTime: Long?,
    @SerializedName("temperatureLow")
    val temperatureLow: Double?,
    @SerializedName("temperatureLowTime")
    val temperatureLowTime: Long?,
    @SerializedName("apparentTemperatureHigh")
    val apparentTemperatureHigh: Double?,
    @SerializedName("apparentTemperatureHighTime")
    val apparentTemperatureHighTime: Long?,
    @SerializedName("apparentTemperatureLow")
    val apparentTemperatureLow: Double?,
    @SerializedName("apparentTemperatureLowTime")
    val apparentTemperatureLowTime: Long?,
    @SerializedName("windGustTime")
    val windGustTime: Long?,
    @SerializedName("uvIndexTime")
    val uvIndexTime: Long?,
    @SerializedName("temperatureMin")
    val temperatureMin: Double?,
    @SerializedName("temperatureMinTime")
    val temperatureMinTime: Long?,
    @SerializedName("temperatureMax")
    val temperatureMax: Double?,
    @SerializedName("temperatureMaxTime")
    val temperatureMaxTime: Long?,
    @SerializedName("apparentTemperatureMin")
    val apparentTemperatureMin: Double?,
    @SerializedName("apparentTemperatureMinTime")
    val apparentTemperatureMinTime: Long?,
    @SerializedName("apparentTemperatureMax")
    val apparentTemperatureMax: Double?,
    @SerializedName("apparentTemperatureMaxTime")
    val apparentTemperatureMaxTime: Long?
) : Serializable
