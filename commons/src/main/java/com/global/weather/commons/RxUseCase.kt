package com.global.weather.commons

import io.reactivex.rxjava3.core.Observable

interface RxUseCase<Param, Result> {
    fun run(params: Param? = null): Observable<Result>
}
