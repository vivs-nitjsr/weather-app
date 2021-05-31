package com.global.weather.presentation.model

import androidx.annotation.DrawableRes

data class WeatherHourlyReportUiModel(
    val timeText: String,
    val temperatureText: String,
    val humidityText: String,
    @DrawableRes val icon: Int
)
