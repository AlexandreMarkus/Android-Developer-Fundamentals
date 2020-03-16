package com.example.droidcafeinput

import android.os.Bundle
import android.widget.Toast
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

        sameday_radioButton.setOnClickListener{
            displayToast(getString(R.string.same_day_radiotext))
        }

        nextday_radioButton.setOnClickListener{
            displayToast(getString(R.string.next_day_radiotext))
        }

        pickup_radioButton.setOnClickListener {
            displayToast(getString(R.string.pick_up_radiotext))
        }
    }

    /**
     * Displays a Toast with the message.
     *
     * @param message Message to display
     */
    private fun displayToast(message: String?) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }
}