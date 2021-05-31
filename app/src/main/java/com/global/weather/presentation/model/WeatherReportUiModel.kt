package com.global.weather.presentation.model

import androidx.annotation.DrawableRes
import com.global.weather.presentation.model.WeatherBaseUiModel.Companion.ITEM_TYPE_HEADER

data class WeatherReportUiModel(
    val timezone: String,
    @DrawableRes val icon: Int,
    val dateText: String,
    val summary: String,
    val temperature: String,
    val minMaxTemperature: String,
    val hourlyReportList: List<WeatherHourlyReportUiModel>
) : WeatherBaseUiModel {
    override val type: Int
        get() = ITEM_TYPE_HEADER
}
