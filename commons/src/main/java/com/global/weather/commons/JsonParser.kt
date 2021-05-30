package com.global.weather.commons

import com.google.gson.Gson

class JsonParser {
    fun <T> parse(jsonString: String, clazz: Class<T>): T? =
        try {
            Gson().fromJson(jsonString, clazz)
        } catch (e: Exception) {
            null
        }
}
