package com.example.hellocompat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random.Default.nextInt


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mColorArray = arrayOf(
            "red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black"
        )

        // restore saved instance state (the text color)
        if (savedInstanceState != null) {
            hello_textview.setTextColor(savedInstanceState.getInt("color"));
        }

        button.setOnClickListener {
            val colorName = mColorArray[nextInt(20)]
            val colorResourceName = resources.getIdentifier(
                colorName,
                "color", applicationContext.packageName
            )
            val colorRes = resources.getColor(colorResourceName, this.theme)
            hello_textview.setTextColor(colorRes)

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // save the current text color
        outState.putInt("color", hello_textview.currentTextColor)
    }
}
