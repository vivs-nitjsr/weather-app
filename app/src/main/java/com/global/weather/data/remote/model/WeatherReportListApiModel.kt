package com.global.weather.data.remote.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

internal class WeatherReportListApiModel(
    @SerializedName("summary")
    val summary: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("data")
    val weatherReport: List<WeatherReportApiModel>
) : Serializable
