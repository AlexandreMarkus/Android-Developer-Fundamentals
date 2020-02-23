package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tag = MainActivity::class.java.simpleName

        Log.d(tag, "-------");
        Log.d(tag, "onCreate");

        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        // Restore the saved state.
// See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            // Show both the header and the message views. If isVisible is
// false or missing from the bundle, use the default layout.
            if (isVisible) {
                text_header_reply.visibility = View.VISIBLE
                text_message_reply.text = savedInstanceState.getString("reply_text")
                text_message_reply.visibility = View.VISIBLE
            }
        }

        button_main.setOnClickListener {
            Log.d(tag, "Button clicked!")
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", "${editText_main.text}")
            startActivityForResult(intent, 1)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // If the heading is visible, message needs to be saved.
// Otherwise we're still using default layout.
        if (text_header_reply.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", "${text_message_reply.text}")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Check which request we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                text_header_reply.visibility = View.VISIBLE
                text_message_reply.visibility = View.VISIBLE
                text_message_reply.text = data?.getStringExtra("EXTRA_REPLY")
                // Do something with the contact here (bigger example below)
            }
        }
    }

}
