package com.global.weather.presentation.ui.adapter.holders

import com.global.weather.databinding.ViewWeatherHourlyItemBinding
import com.global.weather.presentation.model.WeatherHourlyReportUiModel

class WeatherHourlyReportViewHolder(
    private val binding: ViewWeatherHourlyItemBinding
) : BaseViewHolder(binding.root) {

    fun bindView(uiModel: WeatherHourlyReportUiModel) {
        binding.run {
            timeTextView.text = uiModel.timeText
            temperatureTextView.text = uiModel.temperatureText
            humidityTextView.text = uiModel.humidityText
            weatherIconImageView.setImageResource(uiModel.icon)
        }
    }
}
