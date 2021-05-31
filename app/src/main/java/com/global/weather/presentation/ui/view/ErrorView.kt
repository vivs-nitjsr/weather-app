package com.global.weather.presentation.ui.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.global.weather.R
import com.global.weather.databinding.ErrorViewBinding
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class ErrorView : ConstraintLayout {

    companion object {
        private const val DOUBLE_CLICK_TIMEOUT = 900L
    }

    private lateinit var binding: ErrorViewBinding

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        binding = ErrorViewBinding.inflate(LayoutInflater.from(context), this, true)
        initAttributes(attrs)
    }

    private fun initAttributes(attrs: AttributeSet?) {
        attrs?.let {
            val attributes = context.obtainStyledAttributes(it, R.styleable.ErrorView)
            val errorImageId = attributes.getResourceId(
                R.styleable.ErrorView_errorImage,
                R.drawable.ic_error
            )
            val errorTitleColor = attributes.getColor(
                R.styleable.ErrorView_errorTitleColor,
                ContextCompat.getColor(context, R.color.neutral_primary)
            )
            val errorDescriptionColor = attributes.getColor(
                R.styleable.ErrorView_errorDescriptionColor,
                ContextCompat.getColor(context, R.color.neutral_primary)
            )
            val backgroundColor = attributes.getColor(
                R.styleable.ErrorView_backgroundColor,
                ContextCompat.getColor(context, R.color.neutral_light_surface)
            )

            // set attributes
            setErrorImage(errorImageId)
            setErrorDescription(attributes)
            setErrorDescriptionColor(errorDescriptionColor)
            setErrorBackgroundColor(backgroundColor)

            // set localize texts
            setErrorTitleColor(errorTitleColor)
            setErrorTitle(attributes)
            setRetryButtonTitle(attributes)

            attributes.recycle()
        }
    }

    /**
     * set background color of the error view
     */
    fun setErrorBackgroundColor(@ColorInt backgroundColor: Int) {
        binding.mainConstraintLayout.setBackgroundColor(backgroundColor)
    }

    private fun setErrorTitle(attributes: TypedArray) {
        binding.errorTitleTextView.text = attributes.getString(R.styleable.ErrorView_errorTitle)
    }

    fun setErrorTitleColor(@ColorInt titleColor: Int) {
        binding.errorTitleTextView.setTextColor(titleColor)
    }

    private fun setErrorDescription(attributes: TypedArray) {
        binding.errorDescriptionTextView.text = attributes.getString(R.styleable.ErrorView_errorDescription)
    }

    fun setErrorDescription(errorMessage: String?) {
        binding.errorDescriptionTextView.text = errorMessage
    }

    fun setErrorTitle(errorTitle: String?) {
        binding.errorTitleTextView.text = errorTitle
    }

    fun setRetryButtonTitle(retryButtonTitle: String) {
        binding.retryButton.text = retryButtonTitle
    }

    fun setErrorDescriptionColor(@ColorInt descriptionColor: Int) {
        binding.errorDescriptionTextView.setTextColor(descriptionColor)
    }

    private fun setRetryButtonTitle(attributes: TypedArray) {
        binding.retryButton.text = attributes.getString(R.styleable.ErrorView_errorRetryTitle)
    }

    fun addRetryButtonClickObservable(): Observable<Unit> {
        return binding.retryButton.clicks().throttleFirst(DOUBLE_CLICK_TIMEOUT, TimeUnit.MILLISECONDS)
    }

    /**
     * Set Error image using drawable object
     */
    fun setErrorImage(imageDrawable: Drawable) {
        binding.errorImageView.setImageDrawable(imageDrawable)
    }

    /**
     * Set Error image using drawable resource int
     */
    fun setErrorImage(@DrawableRes imageDrawableInt: Int) {
        binding.errorImageView.setImageResource(imageDrawableInt)
    }
}
