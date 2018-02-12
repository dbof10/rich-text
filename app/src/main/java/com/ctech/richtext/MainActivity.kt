package com.ctech.richtext

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.btRainbow
import kotlinx.android.synthetic.main.activity_main.btSetSpan
import kotlinx.android.synthetic.main.activity_main.btSpanStyle
import kotlinx.android.synthetic.main.activity_main.btTextRound
import kotlinx.android.synthetic.main.activity_main.btType


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

        btTextRound.setOnClickListener {
            val intent = Intent(this, TextSurroundActivity::class.java)
            startActivity(intent)
        }

        btRainbow.setOnClickListener {
            val intent = Intent(this, RainbowSpanActivity::class.java)
            startActivity(intent)
        }

        btType.setOnClickListener {
            val intent = Intent(this, TypeWriterSpanActivity::class.java)
            startActivity(intent)
        }

    }
}
