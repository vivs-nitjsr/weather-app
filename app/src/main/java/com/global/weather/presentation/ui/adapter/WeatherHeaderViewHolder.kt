package com.global.weather.presentation.ui.adapter

import com.global.weather.databinding.ViewWeatherHeaderItemBinding
import com.global.weather.presentation.model.WeatherReportUiModel
import com.global.weather.presentation.ui.adapter.holders.BaseViewHolder

internal class WeatherHeaderViewHolder(val binding: ViewWeatherHeaderItemBinding) : BaseViewHolder(binding.root) {
    fun bindView(uiModel: WeatherReportUiModel) {
        binding.run {
            timezoneTextView.text = uiModel.timezone
            dateTextView.text = uiModel.dateText
            temperatureTextView.text = uiModel.temperature
            summaryTextView.text = uiModel.summary
            minMaxTemperatureTextView.text = uiModel.minMaxTemperature
            weatherIconImageView.setImageResource(uiModel.weatherIcon)
        }
    }
}
