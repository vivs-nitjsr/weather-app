package com.global.weather.data.remote.repository

import com.global.weather.WeatherTestData
import com.global.weather.data.remote.api.WeatherApi
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
internal class WeatherRepositoryImplTest {

    private companion object {
        const val TEST_LATITUDE = 59.337239
        const val TEST_LONGITUDE = 18.062381
    }

    @Mock
    private lateinit var weatherApi: WeatherApi

    private lateinit var repository: WeatherRepositoryImpl


    @Before
    fun setUp() {
        whenever(weatherApi.getWeather(any(), any()))
            .thenReturn(Observable.just(WeatherTestData.weatherApiModel))

        repository = WeatherRepositoryImpl(weatherApi)
    }

    @Test
    fun `verify successful weather api model is retrieved from repository`() {
        val actualResult = repository.getWeather(TEST_LATITUDE, TEST_LONGITUDE).test()

        actualResult.assertComplete()
        actualResult.assertNoErrors()
        actualResult.assertValue(WeatherTestData.weatherApiModel)
    }

    @Test
    fun `verify error is thrown when api fails to retrieve weather report`() {
        val throwable = Throwable("some-error")
        whenever(weatherApi.getWeather(any(), any()))
            .thenReturn(Observable.error(throwable))

        val actualResult = repository.getWeather(TEST_LATITUDE, TEST_LONGITUDE).test()

        actualResult.assertError(throwable)
    }
}
