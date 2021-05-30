package com.global.weather.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.global.weather.commons.disposedBy
import com.global.weather.domain.model.Location
import com.global.weather.domain.model.Weather
import com.global.weather.domain.usecase.GetWeatherUseCase
import com.global.weather.presentation.mapper.WeatherReportUiModelMapper
import com.global.weather.presentation.model.WeatherReportUiModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

internal class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val weatherReportUiModelMapper: WeatherReportUiModelMapper
) : BaseViewModel() {

    private val weatherReportState = MutableLiveData<List<WeatherReportUiModel>>()
    val weatherReportViewState: LiveData<List<WeatherReportUiModel>>
        get() = weatherReportState

    fun onViewReady(location: Location) {
        getWeather(location)
    }

    private fun getWeather(location: Location) {
        getWeatherUseCase.run(location)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { showLoading() }
            .doAfterTerminate { hideLoading() }
            .map {
                weatherReportUiModelMapper.map(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { onWeatherRetrieved(it) },
                { onWeatherFetchFailed(it) }
            )
            .disposedBy(compositeDisposable)
    }

    private fun onWeatherRetrieved(weatherReport: List<WeatherReportUiModel>) {
        weatherReportState.value = weatherReport
    }

    private fun onWeatherFetchFailed(throwable: Throwable) {

    }
}

internal sealed class WeatherViewState {
    data class Success(val weather: Weather) : WeatherViewState()
}
