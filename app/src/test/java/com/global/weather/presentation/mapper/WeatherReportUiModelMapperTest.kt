package com.global.weather.presentation.mapper

import com.global.weather.R
import com.global.weather.WeatherTestData
import com.global.weather.presentation.model.WeatherBaseUiModel
import com.global.weather.presentation.model.WeatherReportMoreUiModel
import com.global.weather.presentation.model.WeatherReportUiModel
import com.global.weather.utils.StringLocalizer
import com.global.weather.utils.toCelsius
import com.global.weather.utils.toDate
import com.global.weather.utils.toWeatherIconDrawable
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
internal class WeatherReportUiModelMapperTest {

    private lateinit var mapper: WeatherReportUiModelMapper

    @Mock
    private lateinit var stringLocalizer: StringLocalizer

    @Before
    fun setUp() {
        whenever(stringLocalizer.getString(R.string.uv_index)).thenReturn("UV Index")
        whenever(stringLocalizer.getString(R.string.wind)).thenReturn("Wind")
        whenever(stringLocalizer.getString(R.string.humidity)).thenReturn("Humidity")
        whenever(stringLocalizer.getString(R.string.dew_point)).thenReturn("Dew Point")
        whenever(stringLocalizer.getString(R.string.visibility)).thenReturn("Visibility")
        whenever(stringLocalizer.getString(R.string.ozone)).thenReturn("Ozone")

        mapper = WeatherReportUiModelMapper(stringLocalizer)
    }

    @Test
    fun `verify model mapper returns correct values`() {
        val weather = WeatherTestData.weather
        val actual = mapper.map(weather)
        val expected: MutableList<WeatherBaseUiModel> = arrayListOf(
            WeatherReportUiModel(
                timezone = weather.timezone,
                dateText = weather.currentWeather.time.toDate(),
                summary = weather.currentWeather.summary,
                temperature = weather.currentWeather.temperature?.toCelsius() ?: "",
                minMaxTemperature = "${weather.currentWeather.temperatureMax} / ${weather.currentWeather.temperatureMin}",
                icon = weather.currentWeather.icon.toWeatherIconDrawable(),
                hourlyReportList = weather.hourlyWeatherReportList.toHourlyReport()
            ),
            WeatherReportMoreUiModel(
                uvText = "UV Index",
                uvValue = weather.currentWeather.uvIndex.toString(),
                windText = "Wind",
                windValue = "${weather.currentWeather.windSpeed} km/hr",
                icon = weather.currentWeather.icon.toWeatherIconDrawable(),
                humidityText = "Humidity",
                humidityValue = "${(weather.currentWeather.humidity * 100).toInt()} %",
                dewPointText = "Dew Point",
                dewPointValue = weather.currentWeather.dewPoint.toString(),
                visibilityText = "Visibility",
                visibilityValue = weather.currentWeather.visibility.toString(),
                ozoneText = "Ozone",
                ozoneValue = weather.currentWeather.ozone.toString()
            )
        )
        expected.addAll(weather.dailyWeatherReportList.toDailyWeatherReport())

        assertEquals(expected, actual)
    }
}
