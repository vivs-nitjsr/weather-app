package com.global.weather.commons

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.disposedBy(compositeDisposable: CompositeDisposable): Disposable {
    compositeDisposable.add(this)

    return this
}

