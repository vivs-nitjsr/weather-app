package com.global.weather.presentation.model

import androidx.annotation.DrawableRes

data class WeatherReportUiModel(
    val timezone: String,
    val dateText: String,
    val summary: String,
    val temperature: String,
    val minMaxTemperature: String,
    @DrawableRes val weatherIcon: Int
)
