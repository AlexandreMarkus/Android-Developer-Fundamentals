package com.example.dialogforalert

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    button.setOnClickListener {
        val myAlertBuilder = AlertDialog.Builder(this@MainActivity)
        // Set the alert dialog title
        myAlertBuilder.setTitle("Alert")

        // Display a message on alert dialog
        myAlertBuilder.setMessage("Click OK to continue, or Cancel to stop:")

        // Set a positive button and its click listener on alert dialog
        myAlertBuilder.setPositiveButton("YES"){dialog, which ->
            // Do something when user press the positive button
            Toast.makeText(applicationContext,"Ok, we agreed.",Toast.LENGTH_SHORT).show()
        }

        // Display a negative button on alert dialog
        myAlertBuilder.setNegativeButton("No"){dialog,which ->
            Toast.makeText(applicationContext,"You are not agree.",Toast.LENGTH_SHORT).show()
        }

        // Display a neutral button on alert dialog
        myAlertBuilder.setNeutralButton("Cancel"){_,_ ->
            Toast.makeText(applicationContext,"You cancelled the dialog.",Toast.LENGTH_SHORT).show()
        }

        // Display the alert dialog on app interface
        myAlertBuilder.show()
    }
    }
}
