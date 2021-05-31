package com.global.weather.presentation.ui.adapter.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.global.weather.databinding.ViewWeatherHeaderItemBinding
import com.global.weather.databinding.ViewWeatherHourlyItemBinding
import com.global.weather.presentation.model.WeatherHourlyReportUiModel
import com.global.weather.presentation.model.WeatherReportUiModel

internal class WeatherHeaderViewHolder(
    private val binding: ViewWeatherHeaderItemBinding
) : BaseViewHolder(binding.root) {
    private var isRecyclerViewLoaded = false

    fun bindView(uiModel: WeatherReportUiModel) {
        binding.run {
            timezoneTextView.text = uiModel.timezone
            dateTextView.text = uiModel.dateText
            temperatureTextView.text = uiModel.temperature
            summaryTextView.text = uiModel.summary
            weatherIconImageView.setImageResource(uiModel.icon)
            if (!isRecyclerViewLoaded) loadHourlyReport(uiModel.hourlyReportList)
        }
    }

    private fun loadHourlyReport(list: List<WeatherHourlyReportUiModel>) {
        this.isRecyclerViewLoaded = true
        binding.run {
            hourlyReportRecyclerView.adapter = HourWeatherReportAdapter(list)
        }
    }
}

private class HourWeatherReportAdapter(
    val list: List<WeatherHourlyReportUiModel>
) : RecyclerView.Adapter<WeatherHourlyReportViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHourlyReportViewHolder {
        return WeatherHourlyReportViewHolder(
            ViewWeatherHourlyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: WeatherHourlyReportViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    override fun getItemCount() = list.size
}
