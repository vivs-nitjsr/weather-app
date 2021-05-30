package com.global.weather.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import com.global.weather.R
import com.global.weather.databinding.FragmentWeatherBinding
import com.global.weather.presentation.ui.adapter.WeatherAdapter

class WeatherFragment : BaseFragment<FragmentWeatherBinding>(R.layout.fragment_weather) {

    companion object {
        fun newInstance() = WeatherFragment()
    }

    private val adapter = WeatherAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun bindView(view: View) = FragmentWeatherBinding.bind(view)

    override fun onViewCreated(view: View) {
        viewBinding.run {
            weatherRecyclerView.adapter = adapter
        }
    }
}
