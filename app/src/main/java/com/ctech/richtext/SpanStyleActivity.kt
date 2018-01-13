package com.ctech.richtext

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.ImageSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import android.text.style.TypefaceSpan
import android.text.style.UnderlineSpan
import kotlinx.android.synthetic.main.activity_span_style.tvAbsolute
import kotlinx.android.synthetic.main.activity_span_style.tvBackground
import kotlinx.android.synthetic.main.activity_span_style.tvForeground
import kotlinx.android.synthetic.main.activity_span_style.tvImage
import kotlinx.android.synthetic.main.activity_span_style.tvRelative
import kotlinx.android.synthetic.main.activity_span_style.tvStrikethrough
import kotlinx.android.synthetic.main.activity_span_style.tvStyle
import kotlinx.android.synthetic.main.activity_span_style.tvTypeface
import kotlinx.android.synthetic.main.activity_span_style.tvUnderline


class SpanStyleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_span_style)
        foreground()
        background()
        absoluteSize()
        relativeSize()
        typeface()
        style()
        strikeThrough()
        underline()
        image()
    }


    private fun foreground() {
        val foreground = "Foreground"
        val sp = SpannableString(foreground)
        sp.setSpan(ForegroundColorSpan(Color.RED), 0, foreground.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvForeground.text = sp

    }

    private fun background() {
        val background = "Background"
        val sp = SpannableString(background)
        sp.setSpan(BackgroundColorSpan(Color.parseColor("#2ABA8F")), 0, background.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvBackground.text = sp

    }

    private fun relativeSize() {
        val relative = "Relative size"
        val sp = SpannableString(relative)
        sp.setSpan(RelativeSizeSpan(2.0F), 0, relative.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvRelative.text = sp
    }

    private fun absoluteSize() {
        val absolute = "Absolute size"
        val sp = SpannableString(absolute)
        sp.setSpan(AbsoluteSizeSpan(18, true), 0, absolute.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvAbsolute.text = sp
    }

    private fun typeface() {
        val typeface = "Typeface"
        val sp = SpannableString(typeface)
        sp.setSpan(TypefaceSpan("serif"), 0, typeface.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvTypeface.text = sp
    }


    private fun style() {
        val style = "Style"
        val sp = SpannableString(style)
        sp.setSpan(StyleSpan(Typeface.ITALIC), 0, style.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvStyle.text = sp
    }


    private fun strikeThrough() {
        val strike = "Strikethrough"
        val sp = SpannableString(strike)
        sp.setSpan(StrikethroughSpan(), 0, strike.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvStrikethrough.text = sp
    }

    private fun underline() {
        val underline = "Underline"
        val sp = SpannableString(underline)
        sp.setSpan(UnderlineSpan(), 0, underline.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvUnderline.text = sp
    }


    private fun image() {
        val image = "Image"
        val sp = SpannableString(image)
        val drawable = ContextCompat.getDrawable(this, R.drawable.ic_i)
        drawable!!.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
        sp.setSpan(ImageSpan(drawable, ImageSpan.ALIGN_BASELINE), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvImage.text = sp
    }

}