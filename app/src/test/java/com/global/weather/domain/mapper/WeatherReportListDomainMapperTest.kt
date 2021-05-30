package com.global.weather.domain.mapper

import com.global.weather.WeatherTestData
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class WeatherReportListDomainMapperTest {
    @Mock
    private lateinit var weatherReportDomainMapper: WeatherReportDomainMapper

    private lateinit var mapper: WeatherReportListDomainMapper

    @Before
    fun setUp() {
        whenever(weatherReportDomainMapper.map(any()))
            .thenReturn(WeatherTestData.weatherReport)

        mapper = WeatherReportListDomainMapper(weatherReportDomainMapper)
    }

    @Test
    fun `verify mapper maps weatherReportApiModel to correct weather report domain model`() {
        val actual = mapper.map(WeatherTestData.weatherReportListApiModel)
        val expected = WeatherTestData.weatherReportList

        assertEquals(expected, actual)
    }
}
