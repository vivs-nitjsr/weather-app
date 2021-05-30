package com.global.weather.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import com.global.weather.R
import com.global.weather.commons.ViewModelFactory
import com.global.weather.commons.observe
import com.global.weather.commons.withViewModel
import com.global.weather.databinding.FragmentWeatherBinding
import com.global.weather.di.WeatherApp
import com.global.weather.domain.model.Location
import com.global.weather.presentation.model.WeatherBaseUiModel
import com.global.weather.presentation.ui.adapter.WeatherAdapter
import com.global.weather.presentation.viewmodel.WeatherViewModel
import com.global.weather.utils.MarginItemDecoration
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

internal class WeatherFragment : BaseFragment<FragmentWeatherBinding>(R.layout.fragment_weather), HasAndroidInjector {

    companion object {
        @JvmStatic
        fun newInstance() = WeatherFragment()
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private val adapter = WeatherAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        withViewModel<WeatherViewModel>(viewModelFactory) {
            observeWeatherReportViewState()
        }
    }

    private fun WeatherViewModel.observeWeatherReportViewState() {
        observe(weatherReportViewState) {
            updateRecyclerView(it)
        }
    }

    override fun bindView(view: View) = FragmentWeatherBinding.bind(view)

    override fun onCreate(savedInstanceState: Bundle?) {
        WeatherApp.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.onViewReady(location = Location(59.337239, 18.062381))
        viewBinding.run {
            weatherRecyclerView.addItemDecoration(MarginItemDecoration(resources.getDimension(R.dimen.d2).toInt()))
            weatherRecyclerView.adapter = adapter
        }
    }

    private fun updateRecyclerView(data: List<WeatherBaseUiModel>) {
        adapter.update(data)
    }

    override fun androidInjector() = androidInjector
}
