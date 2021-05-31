package com.global.weather.di.module

import android.app.Application
import com.global.weather.commons.AssetFileLoader
import com.global.weather.commons.JsonParser
import com.global.weather.data.remote.api.WeatherApi
import com.global.weather.data.remote.repository.WeatherRepositoryImpl
import com.global.weather.di.builder.ViewModelFactoryBuilder
import com.global.weather.domain.mapper.WeatherDomainMapper
import com.global.weather.domain.mapper.WeatherReportDomainMapper
import com.global.weather.domain.mapper.WeatherReportListDomainMapper
import com.global.weather.domain.repository.WeatherRepository
import com.global.weather.utils.StringLocalizer
import com.global.weather.utils.StringLocalizerImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module(includes = [ViewModelFactoryBuilder::class])
internal class WeatherModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(
        weatherApi: WeatherApi,
        app: Application,
        assetFileLoader: AssetFileLoader,
        jsonParser: JsonParser
    ): WeatherRepository {
        return WeatherRepositoryImpl(
            weatherApi = weatherApi,
            app = app,
            assetFileLoader = assetFileLoader,
            jsonParser = jsonParser
        )
    }

    @Reusable
    @Provides
    fun provideJsonParser() = JsonParser()

    @Reusable
    @Provides
    fun provideAssetFileLoader() = AssetFileLoader()

    @Reusable
    @Provides
    fun provideWeatherReportDomainMapper() = WeatherReportDomainMapper()

    @Reusable
    @Provides
    fun provideWeatherReportListDomainMapper(
        weatherReportDomainMapper: WeatherReportDomainMapper
    ): WeatherReportListDomainMapper {
        return WeatherReportListDomainMapper(
            weatherReportDomainMapper = weatherReportDomainMapper
        )
    }

    @Reusable
    @Provides
    fun provideWeatherDomainMapper(
        weatherReportDomainMapper: WeatherReportDomainMapper,
        weatherReportListDomainMapper: WeatherReportListDomainMapper
    ): WeatherDomainMapper {
        return WeatherDomainMapper(
            weatherReportDomainMapper = weatherReportDomainMapper,
            weatherReportListDomainMapper = weatherReportListDomainMapper
        )
    }

    @Reusable
    @Provides
    fun provideStringLocalizer(application: Application): StringLocalizer {
        return StringLocalizerImpl(application)
    }
}
