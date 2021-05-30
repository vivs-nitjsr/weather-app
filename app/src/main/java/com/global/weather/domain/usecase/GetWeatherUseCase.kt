package com.global.weather.domain.usecase

import com.global.weather.commons.RxUseCase
import com.global.weather.domain.mapper.WeatherDomainMapper
import com.global.weather.domain.model.Location
import com.global.weather.domain.model.Weather
import com.global.weather.domain.repository.WeatherRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository,
    private val weatherDomainMapper: WeatherDomainMapper
) : RxUseCase<Location, Weather> {
    override fun run(params: Location?): Observable<Weather> {
        checkNotNull(params) { "location cannot be null" }

        return repository.getWeather(
            latitude = params.latitude,
            longitude = params.longitude
        )
            .map { weatherDomainMapper.map(it) }
            .subscribeOn(Schedulers.io())
    }
}
