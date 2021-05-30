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
        precipIntensity = 0.0012f,
        precipProbability = 0.12f,
        temperature = 53.06f,
        apparentTemperature = 53.06f,
        dewPoint = 52.3f,
        humidity = 0.64f,
        pressure = 1020.5f,
        windSpeed = 5.55f,
        windGust = 15.88f,
        windBearing = 61f,
        cloudCover = 0.81f,
        uvIndex = 3,
        visibility = 10,
        ozone = 352.1f,
        sunriseTime = 1622943480L,
        sunsetTime = 1623009480L,
        moonPhase = 0.89f,
        precipIntensityMax = 0.0051f,
        precipIntensityMaxTime = 1622948100L,
        precipType = "rain",
        temperatureHigh = 76.32f,
        temperatureHighTime = 1622987400L,
        temperatureLow = 53.44f,
        temperatureLowTime = 1623031020L,
        apparentTemperatureHigh = 75.82f,
        apparentTemperatureHighTime = 1622987400L,
        apparentTemperatureLow = 53.93f,
        apparentTemperatureLowTime = 1623031020L,
        windGustTime = 1622941380L,
        uvIndexTime = 1622975160L,
        temperatureMin = 54.91f,
        temperatureMinTime = 1622944440L,
        temperatureMax = 76.32f,
        temperatureMaxTime = 1622987400L,
        apparentTemperatureMin = 55.4f,
        apparentTemperatureMinTime = 1622944440L,
        apparentTemperatureMax = 75.82f,
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
        precipIntensity = 0.0012f,
        precipProbability = 0.12f,
        temperature = 53.06f,
        apparentTemperature = 53.06f,
        dewPoint = 52.3f,
        humidity = 0.64f,
        pressure = 1020.5f,
        windSpeed = 5.55f,
        windGust = 15.88f,
        windBearing = 61f,
        cloudCover = 0.81f,
        uvIndex = 3,
        visibility = 10,
        ozone = 352.1f,
        sunriseTime = 1622943480L,
        sunsetTime = 1623009480L,
        moonPhase = 0.89f,
        precipIntensityMax = 0.0051f,
        precipIntensityMaxTime = 1622948100L,
        precipType = "rain",
        temperatureHigh = 76.32f,
        temperatureHighTime = 1622987400L,
        temperatureLow = 53.44f,
        temperatureLowTime = 1623031020L,
        apparentTemperatureHigh = 75.82f,
        apparentTemperatureHighTime = 1622987400L,
        apparentTemperatureLow = 53.93f,
        apparentTemperatureLowTime = 1623031020L,
        windGustTime = 1622941380L,
        uvIndexTime = 1622975160L,
        temperatureMin = 54.91f,
        temperatureMinTime = 1622944440L,
        temperatureMax = 76.32f,
        temperatureMaxTime = 1622987400L,
        apparentTemperatureMin = 55.4f,
        apparentTemperatureMinTime = 1622944440L,
        apparentTemperatureMax = 75.82f,
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
