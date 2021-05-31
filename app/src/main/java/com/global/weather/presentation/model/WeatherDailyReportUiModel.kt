package com.global.weather.presentation.model

import androidx.annotation.DrawableRes
import com.global.weather.presentation.model.WeatherBaseUiModel.Companion.ITEM_TYPE_DAILY_REPORT_ITEM

data class WeatherDailyReportUiModel(
    val dateText: String,
    val humidityText: String,
    val minMaxTemperatureText: String,
    @DrawableRes val icon: Int
) : WeatherBaseUiModel {
    override val type: Int
        get() = ITEM_TYPE_DAILY_REPORT_ITEM
}
