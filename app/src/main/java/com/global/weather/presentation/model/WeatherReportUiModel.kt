package com.global.weather.presentation.model

import androidx.annotation.DrawableRes
import com.global.weather.presentation.model.WeatherBaseUiModel.Companion.ITEM_TYPE_HEADER

data class WeatherReportUiModel(
    val timezone: String,
    val dateText: String,
    val summary: String,
    val temperature: String,
    val minMaxTemperature: String,
    @DrawableRes val weatherIcon: Int
) : WeatherBaseUiModel {
    override val type: Int
        get() = ITEM_TYPE_HEADER
}
