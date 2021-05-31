package com.global.weather.presentation.model

import com.global.weather.presentation.model.WeatherBaseUiModel.Companion.ITEM_TYPE_DAILY_REPORT_ITEM

data class WeatherDailyReportUiModel(
    val dateText: String,
    val humidityText: String,
    val minMaxTemperatureText: String
) : WeatherBaseUiModel {
    override val type: Int
        get() = ITEM_TYPE_DAILY_REPORT_ITEM
}
