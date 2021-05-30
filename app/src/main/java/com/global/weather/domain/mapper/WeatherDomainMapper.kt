package com.global.weather.domain.mapper

import com.global.weather.commons.Mapper
import com.global.weather.data.remote.model.WeatherApiModel
import com.global.weather.domain.model.Weather

internal class WeatherDomainMapper(
    private val weatherReportDomainMapper: WeatherReportDomainMapper,
    private val weatherReportListDomainMapper: WeatherReportListDomainMapper
) : Mapper<WeatherApiModel, Weather> {
    override fun map(from: WeatherApiModel): Weather {
        return Weather(
            latitude = from.latitude,
            longitude = from.longitude,
            timezone = from.timezone,
            currentWeather = from.currentWeather.let { weatherReportDomainMapper.map(it) },
            hourlyWeatherReportList = from.hourlyWeatherReportList.let { weatherReportListDomainMapper.map(it) },
            dailyWeatherReportList = from.dailyWeatherReportList.let { weatherReportListDomainMapper.map(it) }
        )
    }
}
