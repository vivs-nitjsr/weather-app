package com.global.weather.presentation.viewmodel

import com.global.weather.commons.disposedBy
import com.global.weather.domain.model.Location
import com.global.weather.domain.model.Weather
import com.global.weather.domain.usecase.GetWeatherUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

internal class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : BaseViewModel() {

    fun onViewReady(location: Location) {
        getWeather(location)
    }

    private fun getWeather(location: Location) {
        getWeatherUseCase.run(location)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { showLoading() }
            .doAfterTerminate { hideLoading() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ weather ->
                onWeatherRetrieved(weather)
            }, {
                onWeatherFetchFailed(it)
            })
            .disposedBy(compositeDisposable)
    }

    private fun onWeatherRetrieved(weather: Weather) {

    }

    private fun onWeatherFetchFailed(throwable: Throwable) {

    }
}

internal sealed class WeatherViewState {
    data class Success(val weather: Weather) : WeatherViewState()
}
