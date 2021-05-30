package com.global.weather.presentation.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.global.weather.R
import com.global.weather.commons.bind
import com.global.weather.presentation.ui.fragment.WeatherFragment

class WeatherActivity : AppCompatActivity(R.layout.activity_weather) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachWeatherFragment()
    }

    private fun attachWeatherFragment() {
        WeatherFragment.newInstance().bind(this, R.id.containerFrameLayout)
    }
}
