package com.global.weather.presentation.mapper

import android.app.Application
import com.global.weather.R
import com.global.weather.commons.Mapper
import com.global.weather.domain.model.Weather
import com.global.weather.presentation.model.WeatherBaseUiModel
import com.global.weather.presentation.model.WeatherDailyReportUiModel
import com.global.weather.presentation.model.WeatherReportMoreUiModel
import com.global.weather.presentation.model.WeatherReportUiModel
import com.global.weather.utils.toCelsius
import com.global.weather.utils.toDate
import com.global.weather.utils.toDayOfWeek
import javax.inject.Inject

internal class WeatherReportUiModelMapper @Inject constructor(
    private val application: Application
) : Mapper<Weather, List<WeatherBaseUiModel>> {

    override fun map(from: Weather): List<WeatherBaseUiModel> {
        val list = arrayListOf(
            WeatherReportUiModel(
                timezone = from.timezone,
                dateText = from.currentWeather.time.toDate(),
                summary = from.currentWeather.summary,
                temperature = from.currentWeather.temperature?.toCelsius() ?: "",
                minMaxTemperature = "${from.currentWeather.temperatureMax} / ${from.currentWeather.temperatureMin}",
                weatherIcon = R.drawable.cloudy
            ),
            WeatherReportMoreUiModel(
                uvText = application.getString(R.string.uv_index),
                uvValue = from.currentWeather.uvIndex.toString(),
                windText = application.getString(R.string.wind),
                windValue = "${from.currentWeather.windSpeed} km/hr",
                humidityText = application.getString(R.string.humidity),
                humidityValue = "${(from.currentWeather.humidity * 100).toInt()} %",
                dewPointText = application.getString(R.string.dew_point),
                dewPointValue = from.currentWeather.dewPoint.toString(),
                visibilityText = application.getString(R.string.visibility),
                visibilityValue = from.currentWeather.visibility.toString(),
                ozoneText = application.getString(R.string.ozone),
                ozoneValue = from.currentWeather.ozone.toString()
            ),
        )
        list.addAll(getDailyWeatherReport(from))

        return list
    }

    private fun getDailyWeatherReport(from: Weather): List<WeatherDailyReportUiModel> {
        return from.dailyWeatherReportList.weatherReport.map {
            WeatherDailyReportUiModel(
                dateText = it.time.toDayOfWeek(),
                humidityText = "${(it.humidity * 100).toInt()} %",
                minMaxTemperatureText = "${it.temperatureMax?.toCelsius() ?: ""} / ${it.temperatureMin?.toCelsius() ?: ""}",
            )
        }
    }
}
