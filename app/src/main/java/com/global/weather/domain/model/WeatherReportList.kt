package com.global.weather.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
internal data class WeatherReportList(
    val summary: String,
    val icon: String,
    val weatherReport: List<Weather>
) : Parcelable
