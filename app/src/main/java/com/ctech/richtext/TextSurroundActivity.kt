package com.ctech.richtext

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Spannable
import android.text.SpannableString
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import kotlinx.android.synthetic.main.activity_text_surround.ivLogo
import kotlinx.android.synthetic.main.activity_text_surround.tvContent


class TextSurroundActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_surround)

        ivLogo.viewTreeObserver
                .addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        ivLogo.viewTreeObserver
                                .removeOnGlobalLayoutListener(this)

                        val fontSpacing = tvContent.paint.fontSpacing
                        val lines = ( (ivLogo.height + 24) / fontSpacing).toInt()

                        val surroundSpan = TextSurroundSpan(lines, ivLogo.width + 24)
                        val textSpan = SpannableString(getString(R.string.sample_text))
                        textSpan.setSpan(surroundSpan, 0, textSpan.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                        tvContent.text = textSpan

                    }
                })

    }
}