package com.global.weather.utils

import androidx.annotation.StringRes

interface StringLocalizer {
    fun getString(@StringRes id: Int): String
}
