package com.global.weather.utils

import android.annotation.SuppressLint
import com.global.weather.R
import java.text.SimpleDateFormat
import java.util.*

const val ONE_DAY_MILLIS = 24 * 60 * 60 * 1000_000L

@SuppressLint("SimpleDateFormat")
fun Long.toDate(): String = SimpleDateFormat("EEE, dd MMM hh:mm").format(this * 1000L)

fun Double.toCelsius(): String {
    val celsius: Double = (this - 32) * 5 / 9

    return "${celsius.toInt()}\u00B0C"
}

fun Long.toDayOfWeek(): String {
    val timeInMillis = this * 1000L
    val now = System.currentTimeMillis()

    return when {
        now - timeInMillis in 0..ONE_DAY_MILLIS && Date(now).day == Date(timeInMillis).day -> "Today"
        now - timeInMillis in 0..ONE_DAY_MILLIS -> "Yesterday"
        timeInMillis - now in 0..7 * ONE_DAY_MILLIS -> SimpleDateFormat("EEEE").format(timeInMillis)

        else -> toDate()
    }
}

fun Long.toHourTime() = SimpleDateFormat("hh:mm").format(this * 1000L)

fun String.toWeatherIconDrawable(): Int {
    return when {
        contains("rain", ignoreCase = true) -> R.drawable.rain
        contains("storm", ignoreCase = true) -> R.drawable.storm
        contains("cloudy", ignoreCase = true) -> R.drawable.cloudy

        else -> R.drawable.sunrise
    }
}
