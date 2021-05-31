package com.global.weather

import com.global.weather.data.remote.model.WeatherApiModel
import com.global.weather.data.remote.model.WeatherReportApiModel
import com.global.weather.data.remote.model.WeatherReportListApiModel
import com.global.weather.domain.model.Weather
import com.global.weather.domain.model.WeatherReport
import com.global.weather.domain.model.WeatherReportList

internal object WeatherTestData {

    val weatherReportApiModel = WeatherReportApiModel(
        time = 1622352927,
        summary = "Clear",
        icon = "clear-day",
        precipIntensity = 0.0012,
        precipProbability = 0.12,
        temperature = 53.06,
        apparentTemperature = 53.06,
        dewPoint = 52.3,
        humidity = 0.64,
        pressure = 1020.5,
        windSpeed = 5.55,
        windGust = 15.88,
        windBearing = 61.0,
        cloudCover = 0.81,
        uvIndex = 3.0,
        visibility = 10.0,
        ozone = 352.1,
        sunriseTime = 1622943480L,
        sunsetTime = 1623009480L,
        moonPhase = 0.89,
        precipIntensityMax = 0.0051,
        precipIntensityMaxTime = 1622948100L,
        precipType = "rain",
        temperatureHigh = 76.32,
        temperatureHighTime = 1622987400L,
        temperatureLow = 53.44,
        temperatureLowTime = 1623031020L,
        apparentTemperatureHigh = 75.82,
        apparentTemperatureHighTime = 1622987400L,
        apparentTemperatureLow = 53.93,
        apparentTemperatureLowTime = 1623031020L,
        windGustTime = 1622941380L,
        uvIndexTime = 1622975160L,
        temperatureMin = 54.91,
        temperatureMinTime = 1622944440L,
        temperatureMax = 76.32,
        temperatureMaxTime = 1622987400L,
        apparentTemperatureMin = 55.4,
        apparentTemperatureMinTime = 1622944440L,
        apparentTemperatureMax = 75.82,
        apparentTemperatureMaxTime = 1622987400L
    )

    val weatherReportListApiModel = WeatherReportListApiModel(
        summary = "Partly cloudy throughout the day.",
        icon = "partly-cloudy-day",
        weatherReport = arrayListOf(weatherReportApiModel)
    )

    val weatherApiModel = WeatherApiModel(
        latitude = 59.337239,
        longitude = 18.062381,
        timezone = "Europe/Stockholm",
        currentWeather = weatherReportApiModel,
        hourlyWeatherReportList = weatherReportListApiModel,
        dailyWeatherReportList = weatherReportListApiModel
    )

    val weatherReport = WeatherReport(
        time = 1622352927,
        summary = "Clear",
        icon = "clear-day",
        precipIntensity = 0.0012,
        precipProbability = 0.12,
        temperature = 53.06,
        apparentTemperature = 53.06,
        dewPoint = 52.3,
        humidity = 0.64,
        pressure = 1020.5,
        windSpeed = 5.55,
        windGust = 15.88,
        windBearing = 61.0,
        cloudCover = 0.81,
        uvIndex = 3.0,
        visibility = 10.0,
        ozone = 352.1,
        sunriseTime = 1622943480L,
        sunsetTime = 1623009480L,
        moonPhase = 0.89,
        precipIntensityMax = 0.0051,
        precipIntensityMaxTime = 1622948100L,
        precipType = "rain",
        temperatureHigh = 76.32,
        temperatureHighTime = 1622987400L,
        temperatureLow = 53.44,
        temperatureLowTime = 1623031020L,
        apparentTemperatureHigh = 75.82,
        apparentTemperatureHighTime = 1622987400L,
        apparentTemperatureLow = 53.93,
        apparentTemperatureLowTime = 1623031020L,
        windGustTime = 1622941380L,
        uvIndexTime = 1622975160L,
        temperatureMin = 54.91,
        temperatureMinTime = 1622944440L,
        temperatureMax = 76.32,
        temperatureMaxTime = 1622987400L,
        apparentTemperatureMin = 55.4,
        apparentTemperatureMinTime = 1622944440L,
        apparentTemperatureMax = 75.82,
        apparentTemperatureMaxTime = 1622987400L
    )

    val weatherReportList = WeatherReportList(
        summary = "Partly cloudy throughout the day.",
        icon = "partly-cloudy-day",
        weatherReport = arrayListOf(weatherReport)
    )

    val weather = Weather(
        latitude = 59.337239,
        longitude = 18.062381,
        timezone = "Europe/Stockholm",
        currentWeather = weatherReport,
        hourlyWeatherReportList = weatherReportList,
        dailyWeatherReportList = weatherReportList
    )
}
