package com.global.weather.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.global.weather.databinding.ViewDailyWeatherReportBinding
import com.global.weather.databinding.ViewWeatherHeaderItemBinding
import com.global.weather.databinding.ViewWeatherMoreItemBinding
import com.global.weather.presentation.model.WeatherBaseUiModel
import com.global.weather.presentation.model.WeatherBaseUiModel.Companion.ITEM_TYPE_DAILY_REPORT_ITEM
import com.global.weather.presentation.model.WeatherBaseUiModel.Companion.ITEM_TYPE_MORE_ITEM
import com.global.weather.presentation.model.WeatherDailyReportUiModel
import com.global.weather.presentation.model.WeatherReportMoreUiModel
import com.global.weather.presentation.model.WeatherReportUiModel
import com.global.weather.presentation.ui.adapter.holders.BaseViewHolder
import com.global.weather.presentation.ui.adapter.holders.WeatherDailyViewHolder
import com.global.weather.presentation.ui.adapter.holders.WeatherHeaderViewHolder
import com.global.weather.presentation.ui.adapter.holders.WeatherMoreViewHolder

internal class WeatherAdapter constructor(
    private val weatherReport: MutableList<WeatherBaseUiModel> = mutableListOf()
) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            ITEM_TYPE_MORE_ITEM -> {
                WeatherMoreViewHolder(
                    ViewWeatherMoreItemBinding.inflate(inflater, parent, false)
                )
            }
            ITEM_TYPE_DAILY_REPORT_ITEM -> {
                WeatherDailyViewHolder(
                    ViewDailyWeatherReportBinding.inflate(inflater, parent, false)
                )
            }
            else -> {
                WeatherHeaderViewHolder(
                    ViewWeatherHeaderItemBinding.inflate(inflater, parent, false)
                )
            }
        }

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val uiModel = weatherReport[position]
        when (holder) {
            is WeatherHeaderViewHolder -> {
                holder.bindView(uiModel as WeatherReportUiModel)
            }
            is WeatherMoreViewHolder -> {
                holder.bindView(uiModel as WeatherReportMoreUiModel)
            }
            is WeatherDailyViewHolder -> {
                holder.bindView(uiModel as WeatherDailyReportUiModel)
            }
        }
    }

    fun update(weatherReport: List<WeatherBaseUiModel>) {
        this.weatherReport.clear()
        this.weatherReport.addAll(weatherReport)
        this.notifyDataSetChanged()
    }

    override fun getItemCount() = weatherReport.size

    override fun getItemViewType(position: Int): Int {
        return weatherReport[position].type
    }
}
