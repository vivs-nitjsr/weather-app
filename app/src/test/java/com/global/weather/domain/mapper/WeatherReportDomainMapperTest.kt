package com.global.weather.domain.mapper

import com.global.weather.WeatherTestData
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WeatherReportDomainMapperTest {

    private lateinit var mapper: WeatherReportDomainMapper

    @Before
    fun setUp() {
        mapper = WeatherReportDomainMapper()
    }

    @Test
    fun `verify mapper maps weatherReportApiModel to correct weatherReport domain model`() {
        val actual = mapper.map(WeatherTestData.weatherReportApiModel)
        val expected = WeatherTestData.weatherReport

        assertEquals(expected, actual)
    }
}
