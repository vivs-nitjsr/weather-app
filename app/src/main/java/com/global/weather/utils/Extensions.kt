package com.global.weather.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun Long.toDate(): String = SimpleDateFormat("EEE, dd MMM hh:mm").format(this * 1000L)

fun Double.toCelsius(): String {
    val celsius: Double = (this - 32) * 5 / 9

    return "${celsius.toInt()}\u00B0C"
}
