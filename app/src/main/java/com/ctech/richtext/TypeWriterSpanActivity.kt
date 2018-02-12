package com.ctech.richtext

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.Spanned
import android.util.Log
import android.util.Property
import android.view.animation.AccelerateDecelerateInterpolator
import kotlinx.android.synthetic.main.activity_rainbow.tvContent


class TypeWriterSpanActivity : AppCompatActivity() {

    private lateinit var contentSpannableString: SpannableString

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_writer)
        contentSpannableString = SpannableString(getString(R.string.sample_rainbow))
        animateTypeWriter()
    }

    private fun buildTypeWriterSpanGroup(start: Int, end: Int): TypeWriterSpanGroup {
        val group = TypeWriterSpanGroup(0F)
        for (index in start..end) {
            val span = MutableForegroundColorSpan(0, Color.BLACK)
            group.addSpan(span)
            contentSpannableString.setSpan(span, index, index + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        return group
    }

    private fun animateTypeWriter() {
        val spanGroup = buildTypeWriterSpanGroup(0, contentSpannableString.length - 1)
        val objectAnimator = ObjectAnimator.ofFloat(spanGroup, TYPE_WRITER_GROUP_ALPHA_PROPERTY, 0.0f, 1.0f)
        objectAnimator.addUpdateListener {
            tvContent.text = contentSpannableString
        }
        objectAnimator.interpolator = AccelerateDecelerateInterpolator()
        objectAnimator.duration = 5000
        objectAnimator.start()
    }

    private inner class TypeWriterSpanGroup constructor(private val mAlpha: Float) {
        private val spans: ArrayList<MutableForegroundColorSpan> = ArrayList()

        var alpha: Float
            get() = mAlpha
            set(alpha) {
                val size = spans.size
                var totalVisible: Float = 1.0f * size * alpha
                Log.e(TypeWriterSpanActivity::class.java.name, "total $totalVisible alpha $alpha")
                (0 until size)
                        .asSequence()
                        .map { spans[it] }
                        .forEach {
                            if (totalVisible > 1.0f) {
                                it.alpha = 255
                                totalVisible -= 1.0f
                            } else {
                                it.alpha = ((totalVisible * 255).toInt())
                                totalVisible = 0F
                            }
                        }
            }

        fun addSpan(span: MutableForegroundColorSpan) {
            span.alpha = ((mAlpha * 255).toInt())
            spans.add(span)
        }

    }


    private val TYPE_WRITER_GROUP_ALPHA_PROPERTY = object : Property<TypeWriterSpanGroup, Float>(Float::class.java, "TYPE_WRITER_GROUP_ALPHA_PROPERTY") {

        override fun set(spanGroup: TypeWriterSpanGroup, value: Float) {
            spanGroup.alpha = value
        }


        override fun get(spanGroup: TypeWriterSpanGroup): Float {
            return spanGroup.alpha
        }
    }

}