package com.global.weather.presentation.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()

    fun showLoading() {

    }

    fun hideLoading() {

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
