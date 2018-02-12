package com.ctech.richtext

import android.text.TextPaint
import android.text.style.ForegroundColorSpan

class MutableForegroundColorSpan(var alpha: Int, val color: Int) : ForegroundColorSpan(color) {

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.alpha = alpha
    }
}