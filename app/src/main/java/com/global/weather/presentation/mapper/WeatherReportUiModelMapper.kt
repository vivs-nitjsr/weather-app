package com.global.weather.presentation.mapper

import com.global.weather.R
import com.global.weather.commons.Mapper
import com.global.weather.domain.model.Weather
import com.global.weather.presentation.model.WeatherReportUiModel
import javax.inject.Inject

internal class WeatherReportUiModelMapper @Inject constructor() : Mapper<Weather, List<WeatherReportUiModel>> {
    override fun map(from: Weather): List<WeatherReportUiModel> {
        return arrayListOf(
            WeatherReportUiModel(
                timezone = from.timezone,
                dateText = from.currentWeather.time.toString(),
                summary = from.currentWeather.summary,
                temperature = from.currentWeather.temperature.toString(),
                minMaxTemperature = "${from.currentWeather.temperatureMax} / ${from.currentWeather.temperatureMin}",
                weatherIcon = R.drawable.cloudy
            )
        )
    }
}
