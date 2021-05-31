package com.global.weather.utils

import android.app.Application
import androidx.annotation.StringRes
import javax.inject.Inject

class StringLocalizerImpl @Inject constructor(
    private val application: Application
) : StringLocalizer {
    override fun getString(@StringRes id: Int): String {
        return application.getString(id)
    }
}
