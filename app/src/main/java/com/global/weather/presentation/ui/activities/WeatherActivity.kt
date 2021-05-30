package com.global.weather.presentation.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.global.weather.R
import com.global.weather.databinding.ActivityWeatherBinding
import com.global.weather.di.WeatherApp
import com.global.weather.presentation.ui.fragment.WeatherFragment
import com.global.weather.utils.bind
import com.global.weather.utils.viewBinding
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

internal class WeatherActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private val binding by viewBinding(ActivityWeatherBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        WeatherApp.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        attachWeatherFragment()
    }

    private fun attachWeatherFragment() {
        WeatherFragment.newInstance().bind(this, R.id.containerFrameLayout)
    }

    override fun androidInjector() = androidInjector

}
