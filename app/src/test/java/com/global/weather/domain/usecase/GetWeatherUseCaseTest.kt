package com.global.weather.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.global.weather.TrampolineSchedulerRule
import com.global.weather.WeatherTestData
import com.global.weather.domain.mapper.WeatherDomainMapper
import com.global.weather.domain.model.Location
import com.global.weather.domain.repository.WeatherRepository
import io.reactivex.rxjava3.core.Observable
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetWeatherUseCaseTest {

    private companion object {
        const val TEST_LATITUDE = 59.337239
        const val TEST_LONGITUDE = 18.062381
    }

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @JvmField
    @Rule
    val testSchedulerRule = TrampolineSchedulerRule()

    @Mock
    private lateinit var repository: WeatherRepository

    @Mock
    private lateinit var weatherDomainMapper: WeatherDomainMapper

    private lateinit var usecase: GetWeatherUseCase

    private val location = Location(
        latitude = TEST_LATITUDE,
        longitude = TEST_LONGITUDE
    )

    @Before
    fun setUp() {
        whenever(repository.getWeather(any(), any()))
            .thenReturn(Observable.just(WeatherTestData.weatherApiModel))
        whenever(weatherDomainMapper.map(any()))
            .thenReturn(WeatherTestData.weather)

        usecase = GetWeatherUseCase(
            repository = repository,
            weatherDomainMapper = weatherDomainMapper
        )
    }

    @Test
    fun `verify error is thrown if location info is not sent`() {
        assertThrows("location cannot be null", IllegalStateException::class.java) { usecase.run() }
    }

    @Test
    fun `verify error is thrown if exception is returned from the repository`() {
        val exception = Throwable("some error")
        whenever(repository.getWeather(any(), any()))
            .thenReturn(Observable.error(exception))

        val testObserver = usecase.run(location).test()
        testObserver.assertError(exception)
    }

    @Test
    fun `verify use case returns correct weather observable if location data is provided`() {
        val testObserver = usecase.run(location).test()

        testObserver.assertNoErrors()
        testObserver.assertComplete()
        testObserver.assertValue(WeatherTestData.weather)
    }
}
