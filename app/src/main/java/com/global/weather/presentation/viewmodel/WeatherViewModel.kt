package com.global.weather.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.global.weather.commons.disposedBy
import com.global.weather.domain.model.Location
import com.global.weather.domain.usecase.GetWeatherUseCase
import com.global.weather.presentation.mapper.WeatherReportUiModelMapper
import com.global.weather.presentation.model.WeatherBaseUiModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val weatherReportUiModelMapper: WeatherReportUiModelMapper
) : BaseViewModel() {

    private val weatherReportState = MutableLiveData<List<WeatherBaseUiModel>>()
    val weatherReportViewState: LiveData<List<WeatherBaseUiModel>>
        get() = weatherReportState

    private val weatherState = MutableLiveData<WeatherViewState>()
    val weatherViewState: LiveData<WeatherViewState>
        get() = weatherState

    fun onViewReady(location: Location) {
        getWeather(location)
    }

    private fun getWeather(location: Location) {
        weatherState.postValue(WeatherViewState.HideError)
        weatherState.postValue(WeatherViewState.ShowWeatherReport)
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

    private fun showLoading() {
        weatherState.postValue(WeatherViewState.ShowLoading)
    }

    private fun hideLoading() {
        weatherState.postValue(WeatherViewState.HideLoading)
    }

    private fun onWeatherRetrieved(weatherReport: List<WeatherBaseUiModel>) {
        weatherReportState.value = weatherReport
    }

    private fun onWeatherFetchFailed(throwable: Throwable) {
        weatherState.postValue(WeatherViewState.HideWeatherReport)
        weatherState.postValue(WeatherViewState.ShowError)
    }
}

internal sealed class WeatherViewState {
    object ShowLoading : WeatherViewState()
    object HideLoading : WeatherViewState()
    object ShowWeatherReport : WeatherViewState()
    object HideWeatherReport : WeatherViewState()
    object ShowError : WeatherViewState()
    object HideError : WeatherViewState()
    data class LocationPermissionMissing(val show: Boolean) : WeatherViewState()
}
