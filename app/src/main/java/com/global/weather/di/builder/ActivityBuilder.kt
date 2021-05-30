package com.global.weather.di.builder

import com.global.weather.presentation.ui.activities.WeatherActivity
import com.global.weather.presentation.ui.fragment.WeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindWeatherActivity(): WeatherActivity

    @ContributesAndroidInjector
    abstract fun bindWeatherFragment(): WeatherFragment
}
