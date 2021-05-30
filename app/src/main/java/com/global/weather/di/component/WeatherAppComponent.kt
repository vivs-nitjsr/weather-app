package com.global.weather.di.component

import android.app.Application
import com.global.weather.di.WeatherApp
import com.global.weather.di.builder.ActivityBuilder
import com.global.weather.di.module.NetworkModule
import com.global.weather.di.module.WeatherModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        WeatherModule::class,
        NetworkModule::class
    ]
)
internal interface WeatherAppComponent : AndroidInjector<WeatherApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(app: WeatherApp): Builder

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): WeatherAppComponent
    }
}
