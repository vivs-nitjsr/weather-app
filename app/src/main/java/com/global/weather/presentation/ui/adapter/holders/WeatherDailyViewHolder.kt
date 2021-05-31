package com.global.weather.presentation.ui.adapter.holders

import com.global.weather.databinding.ViewDailyWeatherReportBinding
import com.global.weather.presentation.model.WeatherDailyReportUiModel

internal class WeatherDailyViewHolder(
    private val binding: ViewDailyWeatherReportBinding
) : BaseViewHolder(binding.root) {

    fun bindView(uiModel: WeatherDailyReportUiModel) {
        binding.run {
            dateTextView.text = uiModel.dateText
            humidityTextView.text = uiModel.humidityText
            minMaxTemperatureTextView.text = uiModel.minMaxTemperatureText
        }
    }
}
