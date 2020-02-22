package com.example.hellotoast

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mCount = 0

        button_count.setOnClickListener {
            mCount++
            show_count.text = mCount.toString()
        }

        button_toast.setOnClickListener {
            Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
        }
    }

}
