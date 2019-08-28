package com.vuz.task.presentation.customview

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.vuz.task.R
import android.animation.*
import android.util.Log


class LoadingButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RelativeLayout(context, attrs, defStyle) {

    private var imageView: ImageView? = null
    private var textView: TextView? = null
    private var progressBar: ProgressBar? = null
    private var text: String? = null

    private var backgroundColor: Int? = null
    private var textColor: Int? = null

    init {
        init()
        initAttributes(attrs)
    }

    fun init() {
        isClickable = true
        setBackgroundResource(android.R.drawable.btn_default)
        val imageViewParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        imageViewParams.addRule(CENTER_IN_PARENT)
        val textViewParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        textViewParams.addRule(CENTER_IN_PARENT)
        val progressBarParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        progressBarParams.addRule(CENTER_IN_PARENT)

        imageView = ImageView(context)
        imageView!!.layoutParams = imageViewParams
        imageView!!.setImageResource(R.drawable.baseline_check_circle_white_24)
        imageView!!.visibility = View.INVISIBLE

        textView = TextView(context)
        textView!!.layoutParams = textViewParams
        textView!!.text = text
        textView!!.isAllCaps = true
        textView!!.typeface = Typeface.DEFAULT_BOLD

        progressBar = ProgressBar(context)
        progressBar!!.layoutParams = progressBarParams
        progressBar!!.visibility = View.INVISIBLE

        addView(imageView)
        addView(textView)
        addView(progressBar)
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)
    }

    private fun initAttributes(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingButtonView, 0, 0)
        try {
            text = typedArray.getString(R.styleable.LoadingButtonView_text)
            backgroundColor = typedArray.getColor(R.styleable.LoadingButtonView_backgroundColor, ContextCompat.getColor(context, R.color.colorWhite))
            textColor = typedArray.getColor(R.styleable.LoadingButtonView_textColor, ContextCompat.getColor(context, R.color.colorWhite))
        } finally {
            typedArray.recycle()
        }
        textView!!.text = text
        backgroundColor?.let { setBackgroundColor(it) }
        textColor?.let { textView!!.setTextColor(it) }
    }

    fun setNormalState() {
        progressBar?.visibility = View.INVISIBLE
        textView?.visibility = View.VISIBLE
        imageView!!.visibility = View.INVISIBLE
    }

    fun setLoadingState() {
        progressBar?.visibility = View.VISIBLE
        textView?.visibility = View.INVISIBLE
        imageView!!.visibility = View.INVISIBLE
    }

    fun setSuccessState(successListener: SuccessListener) {
        progressBar?.visibility = View.INVISIBLE
        textView?.visibility = View.INVISIBLE
        imageView?.visibility = View.VISIBLE

        val colorFrom = backgroundColor
        val colorTo = ContextCompat.getColor(context, R.color.colorGreen)
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)
        colorAnimation.duration = 250
        colorAnimation.addUpdateListener { animator ->
                setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                successListener.onReady()
            }
        })
        colorAnimation.start()
    }

}