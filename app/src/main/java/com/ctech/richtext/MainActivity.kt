package com.ctech.richtext

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.btSetSpan
import kotlinx.android.synthetic.main.activity_main.btSpanStyle


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSetSpan.setOnClickListener {
            val intent = Intent(this, SetSpanActivity::class.java)
            startActivity(intent)
        }

        btSpanStyle.setOnClickListener {
            val intent = Intent(this, SpanStyleActivity::class.java)
            startActivity(intent)
        }

    }
}
