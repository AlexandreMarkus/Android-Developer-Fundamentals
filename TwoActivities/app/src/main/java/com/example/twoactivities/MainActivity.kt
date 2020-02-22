package com.example.twoactivities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tag = MainActivity::class.java.simpleName

        button_main.setOnClickListener {
            Log.d(tag, "Button clicked!")
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }


}
