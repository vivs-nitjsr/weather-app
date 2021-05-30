package com.global.weather.domain.mapper

import com.global.weather.WeatherTestData
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class WeatherDomainMapperTest() {

    private lateinit var mapper: WeatherDomainMapper

    @Mock
    private lateinit var weatherReportDomainMapper: WeatherReportDomainMapper

    @Mock
    private lateinit var weatherReportListDomainMapper: WeatherReportListDomainMapper

    @Before
    fun setUp() {
        whenever(weatherReportDomainMapper.map(WeatherTestData.weatherReportApiModel))
            .thenReturn(WeatherTestData.weatherReport)

        whenever(weatherReportListDomainMapper.map(WeatherTestData.weatherReportListApiModel))
            .thenReturn(WeatherTestData.weatherReportList)

        mapper = WeatherDomainMapper(
            weatherReportDomainMapper = weatherReportDomainMapper,
            weatherReportListDomainMapper = weatherReportListDomainMapper
        )
    }

    @Test
    fun `verify mapper maps weatherApiModel to correct weather model`() {
        val actual = mapper.map(WeatherTestData.weatherApiModel)
        val expected = WeatherTestData.weather

        assertEquals(expected, actual)
    }
}
