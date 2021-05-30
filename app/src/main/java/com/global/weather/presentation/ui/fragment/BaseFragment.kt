package com.global.weather.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(@get:LayoutRes val layoutId: Int) : Fragment(layoutId) {

    protected lateinit var viewBinding: VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = bindView(view)
        viewCreated(view, savedInstanceState)
    }

    protected abstract fun viewCreated(view: View, savedInstanceState: Bundle?)

    protected abstract fun bindView(view: View): VB
}
