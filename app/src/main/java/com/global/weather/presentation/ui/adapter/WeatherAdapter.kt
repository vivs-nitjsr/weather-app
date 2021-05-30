package com.global.weather.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.global.weather.databinding.ViewWeatherHeaderItemBinding
import com.global.weather.presentation.model.WeatherReportUiModel
import com.global.weather.presentation.ui.adapter.holders.BaseViewHolder

internal class WeatherAdapter constructor(
    private val weatherReport: MutableList<WeatherReportUiModel> = mutableListOf()
) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = ViewWeatherHeaderItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return WeatherHeaderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (holder is WeatherHeaderViewHolder) {
            holder.bindView(weatherReport[position])
        }
    }

    fun update(weatherReport: List<WeatherReportUiModel>) {
        this.weatherReport.clear()
        this.weatherReport.addAll(weatherReport)
        this.notifyDataSetChanged()
    }

    override fun getItemCount() = weatherReport.size
}
