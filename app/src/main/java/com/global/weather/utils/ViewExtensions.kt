package com.global.weather.utils

import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

fun Fragment.bind(activity: AppCompatActivity, @IdRes containerId: Int) {
    activity.supportFragmentManager.beginTransaction()
        .replace(
            containerId,
            this,
            this.javaClass.name
        )
        .commitAllowingStateLoss()
}

inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T
) = lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater.invoke(layoutInflater)
}


fun AppCompatTextView.leftDrawable(@DrawableRes id: Int = 0) {
    this.setCompoundDrawablesWithIntrinsicBounds(id, 0, 0, 0)
}
