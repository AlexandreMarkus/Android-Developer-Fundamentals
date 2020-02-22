package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val message = intent.getStringExtra("EXTRA_MESSAGE")
        text_message.text = message

        button_second.setOnClickListener {
            val replyIntent = Intent()
            replyIntent.putExtra("EXTRA_REPLY", "${editText_second.text}")
            setResult(Activity.RESULT_OK, replyIntent)
            finish()
        }
    }
}
