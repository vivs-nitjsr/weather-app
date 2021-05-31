package com.global.weather.presentation.model

import androidx.annotation.IntDef

interface WeatherBaseUiModel {
    companion object {
        const val ITEM_TYPE_HEADER = 500
        const val ITEM_TYPE_MORE_ITEM = 501
        const val ITEM_TYPE_DAILY_REPORT_ITEM = 502
    }

    @IntDef(
        ITEM_TYPE_HEADER,
        ITEM_TYPE_MORE_ITEM,
        ITEM_TYPE_DAILY_REPORT_ITEM
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class Type

    val type: Int
}


