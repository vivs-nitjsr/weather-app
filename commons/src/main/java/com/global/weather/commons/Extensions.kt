package com.global.weather.commons

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.disposedBy(compositeDisposable: CompositeDisposable): Disposable {
    compositeDisposable.add(this)

    return this
}

fun Fragment.bind(activity: AppCompatActivity, @IdRes containerId: Int) {
    activity.supportFragmentManager.beginTransaction()
        .replace(
            containerId,
            this,
            this.javaClass.name
        )
        .commitAllowingStateLoss()
}
