package com.global.weather.presentation.ui.adapter.holders

import com.global.weather.databinding.ViewWeatherMoreItemBinding
import com.global.weather.presentation.model.WeatherReportMoreUiModel

internal class WeatherMoreViewHolder(private val binding: ViewWeatherMoreItemBinding) : BaseViewHolder(binding.root) {
    fun bindView(uiModel: WeatherReportMoreUiModel) {
        binding.run {
            uvIndexLayout.itemTitleTextView.text = uiModel.uvText
            uvIndexLayout.itemValueTextView.text = uiModel.uvValue
            windLayout.itemTitleTextView.text = uiModel.windText
            windLayout.itemValueTextView.text = uiModel.windValue
            humidityLayout.itemTitleTextView.text = uiModel.humidityText
            humidityLayout.itemValueTextView.text = uiModel.humidityValue
            dewPointLayout.itemTitleTextView.text = uiModel.dewPointText
            dewPointLayout.itemValueTextView.text = uiModel.dewPointValue
            visibilityLayout.itemTitleTextView.text = uiModel.visibilityText
            visibilityLayout.itemValueTextView.text = uiModel.visibilityValue
            ozoneLayout.itemTitleTextView.text = uiModel.ozoneText
            ozoneLayout.itemValueTextView.text = uiModel.ozoneValue
        }
    }
}
