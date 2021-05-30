package com.global.weather.commons

interface Mapper<Param, Result> {
    fun map(from: Param): Result
}
