package com.global.weather.domain.mapper

import com.global.weather.commons.Mapper
import com.global.weather.data.remote.model.WeatherReportListApiModel
import com.global.weather.domain.model.WeatherReportList
import javax.inject.Inject

internal class WeatherReportListDomainMapper @Inject constructor(
    private val weatherReportDomainMapper: WeatherReportDomainMapper
) : Mapper<WeatherReportListApiModel, WeatherReportList> {
    override fun map(from: WeatherReportListApiModel): WeatherReportList {
        return WeatherReportList(
            summary = from.summary,
            icon = from.icon,
            weatherReport = from.weatherReport.map {
                weatherReportDomainMapper.map(it)
            }
        )
    }
}
