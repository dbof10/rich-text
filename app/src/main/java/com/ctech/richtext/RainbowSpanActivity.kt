package com.ctech.richtext

import android.animation.FloatEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Shader
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.TextPaint
import android.text.format.DateUtils
import android.text.style.CharacterStyle
import android.text.style.UpdateAppearance
import android.util.Property
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_rainbow.tvContent


class RainbowSpanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rainbow)

        val text = tvContent.text

        val span = AnimatedColorSpan(this)

        val spannableString = SpannableString(text)
        val substring = "rainbow"
        val start = text.toString().toLowerCase().indexOf(substring)
        val end = start + substring.length
        spannableString.setSpan(span, start, end, 0)

        val objectAnimator = ObjectAnimator.ofFloat(span, ANIMATED_COLOR_SPAN_FLOAT_PROPERTY, 0F, 100F)
        objectAnimator.setEvaluator(FloatEvaluator())
        objectAnimator.addUpdateListener { tvContent.text = spannableString }
        objectAnimator.interpolator = LinearInterpolator()
        objectAnimator.duration = DateUtils.MINUTE_IN_MILLIS * 3
        objectAnimator.repeatCount = ValueAnimator.INFINITE
        objectAnimator.start()
    }

    private val ANIMATED_COLOR_SPAN_FLOAT_PROPERTY = object : Property<AnimatedColorSpan, Float>(Float::class.java, "ANIMATED_COLOR_SPAN_FLOAT_PROPERTY") {
        override operator fun set(span: AnimatedColorSpan, value: Float) {
            span.translateXPercentage = value
        }

        override operator fun get(span: AnimatedColorSpan): Float? {
            return span.translateXPercentage
        }
    }

    private class AnimatedColorSpan(context: Context) : CharacterStyle(), UpdateAppearance {
        private val colors: IntArray = context.resources.getIntArray(R.array.rainbow)
        private var shader: Shader? = null
        private val matrix = Matrix()
        var translateXPercentage = 0f

        override fun updateDrawState(paint: TextPaint) {
            paint.style = Paint.Style.FILL
            val width = paint.textSize * colors.size
            if (shader == null) {
                shader = LinearGradient(0f, 0f, 0f, width, colors, null,
                        Shader.TileMode.MIRROR)
            }
            matrix.reset()
            matrix.setRotate(90F)
            matrix.postTranslate(width * translateXPercentage, 0F)
            shader!!.setLocalMatrix(matrix)
            paint.shader = shader
        }
    }
}