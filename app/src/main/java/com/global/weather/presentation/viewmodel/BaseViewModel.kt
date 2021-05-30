package com.global.weather.presentation.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

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
