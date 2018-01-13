package com.ctech.richtext

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import kotlinx.android.synthetic.main.activity_set_span.textView
import kotlinx.android.synthetic.main.activity_set_span.textView2
import kotlinx.android.synthetic.main.activity_set_span.textView3


class SetSpanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_set_span)

        val textSpannedBuilder1 = SpannableStringBuilder()
        val textSpanned11 = SpannableString("Hello")
        textSpanned11.setSpan(BackgroundColorSpan(Color.MAGENTA), 0, textSpanned11.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        val textSpanned12 = SpannableString("World")
        textView.text = textSpannedBuilder1.append(textSpanned11).append(textSpanned12)

        val textSpannedBuilder2 = SpannableStringBuilder()
        val textSpanned21 = SpannableString("Hello")
        textSpanned21.setSpan(BackgroundColorSpan(Color.MAGENTA), 0, textSpanned21.length, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
        val textSpanned22 = SpannableString("World")
        textView2.text = textSpannedBuilder2.append(textSpanned21).append(textSpanned22)

        val textSpannedBuilder3 = SpannableStringBuilder()
        val textSpanned31 = SpannableString("Hello")
        textSpanned31.setSpan(BackgroundColorSpan(Color.MAGENTA), 0, textSpanned21.length, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
        val textSpanned32 = SpannableString("World")
        textSpanned32.setSpan(BackgroundColorSpan(Color.GREEN), 0, 3, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
        textView3.text = textSpannedBuilder3.append(textSpanned31).append(textSpanned32)


    }
}