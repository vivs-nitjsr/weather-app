package com.global.weather.di

import android.app.Application
import com.global.weather.di.component.DaggerWeatherAppComponent
import com.global.weather.di.component.WeatherAppComponent
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

internal object WeatherApp {
    @set:Inject
    internal lateinit var injector: DispatchingAndroidInjector<Any>

    fun init(application: Application): WeatherAppComponent {
        return DaggerWeatherAppComponent.builder()
            .app(this)
            .application(application)
            .build()
            .also { it.inject(this) }
    }

    internal fun inject(resources: Any) {
        injector.inject(resources)
    }
}
