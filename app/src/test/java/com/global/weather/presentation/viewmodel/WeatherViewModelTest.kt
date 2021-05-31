package com.global.weather.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.global.weather.TrampolineSchedulerRule
import com.global.weather.WeatherTestData
import com.global.weather.domain.model.Location
import com.global.weather.domain.usecase.GetWeatherUseCase
import com.global.weather.presentation.mapper.WeatherReportUiModelMapper
import com.global.weather.presentation.model.WeatherBaseUiModel
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class WeatherViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @JvmField
    @Rule
    val testSchedulerRule = TrampolineSchedulerRule()

    @Mock
    private lateinit var useCase: GetWeatherUseCase

    @Mock
    private lateinit var mapper: WeatherReportUiModelMapper

    @Mock
    private lateinit var weatherStateObserver: Observer<WeatherViewState>

    @Mock
    private lateinit var weatherReportStateObserver: Observer<List<WeatherBaseUiModel>>

    private val location = Location(1.0, 103.0004)

    private val uiModelList = getMockWeatherReportUiModel()

    private lateinit var viewModel: WeatherViewModel

    @Before
    fun setUp() {
        whenever(mapper.map(any())).thenReturn(uiModelList)
        whenever(useCase.run(any())).thenReturn(Observable.just(WeatherTestData.weather))

        viewModel = WeatherViewModel(
            getWeatherUseCase = useCase,
            weatherReportUiModelMapper = mapper
        )
        viewModel.weatherViewState.observeForever(weatherStateObserver)
        viewModel.weatherReportViewState.observeForever(weatherReportStateObserver)
    }

    @Test
    fun `verify weather report loaded successful when usecase returns value`() {
        viewModel.onViewReady(location)
        verify(weatherStateObserver).onChanged(WeatherViewState.HideError)
        verify(weatherStateObserver).onChanged(WeatherViewState.ShowLoading)
        verify(weatherReportStateObserver).onChanged(uiModelList)
        verify(weatherStateObserver).onChanged(WeatherViewState.HideLoading)
    }

    @Test
    fun `verify error is posted when usecase return error`() {
        whenever(useCase.run(any()))
            .thenReturn(Observable.error(Throwable("some error")))

        viewModel.onViewReady(location)
        verify(weatherStateObserver).onChanged(WeatherViewState.HideError)
        verify(weatherStateObserver).onChanged(WeatherViewState.ShowLoading)
        verify(weatherStateObserver).onChanged(WeatherViewState.ShowError)
        verify(weatherStateObserver).onChanged(WeatherViewState.HideLoading)
    }

    private fun getMockWeatherReportUiModel(): List<WeatherBaseUiModel> {
        return arrayListOf()
    }
}
