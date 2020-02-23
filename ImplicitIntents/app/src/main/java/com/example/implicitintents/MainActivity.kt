package com.example.implicitintents


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        open_location_button.setOnClickListener {
            // Parse the location and create the intent.
            val addressUri = Uri.parse("geo:0,0?q=${location_edittext.text}")
            val intent = Intent(Intent.ACTION_VIEW, addressUri)

            // Find an activity to handle the intent, and start that activity.
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.d("ImplicitIntents", "Can't handle this intent!")
            }
        }

        open_website_button.setOnClickListener {
            val webpage: Uri = Uri.parse("${website_edittext.text}")
            val intent = Intent(Intent.ACTION_VIEW, webpage)

            // Find an activity to hand the intent and start that activity.
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.d("ImplicitIntents", "Can't handle this intent!")
            }
        }

        share_text_button.setOnClickListener {

            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText("${share_edittext.text}")
                .startChooser()
        }
    }
}
