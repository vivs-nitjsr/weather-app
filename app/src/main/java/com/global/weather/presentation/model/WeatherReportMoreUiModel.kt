package com.global.weather.presentation.model

import com.global.weather.presentation.model.WeatherBaseUiModel.Companion.ITEM_TYPE_MORE_ITEM

data class WeatherReportMoreUiModel(
    val uvText: String,
    val uvValue: String,
    val windText: String,
    val windValue: String,
    val humidityText: String,
    val humidityValue: String,
    val dewPointText: String,
    val dewPointValue: String,
    val visibilityText: String,
    val visibilityValue: String,
    val ozoneText: String,
    val ozoneValue: String
) : WeatherBaseUiModel {
    override val type: Int
        get() = ITEM_TYPE_MORE_ITEM
}
