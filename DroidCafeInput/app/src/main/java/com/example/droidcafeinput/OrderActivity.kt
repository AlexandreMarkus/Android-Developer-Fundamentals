package com.example.droidcafeinput

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.droidcafe.R
import kotlinx.android.synthetic.main.activity_order.*

/**
 * This activity shows the order chosen.  The order is sent as data
 * with the intent to launch this activity.
 */
class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Get the intent and its data.
        val message = intent.getStringExtra("EXTRA_MESSAGE")
        order_textview.text = message
    }
}