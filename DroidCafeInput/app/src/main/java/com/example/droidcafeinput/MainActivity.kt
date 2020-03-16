package com.example.droidcafeinput


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android.droidcafe.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


/**
 * This app demonstrates images used as buttons and a floating action button
 * to use an intent to launch a second activity. The app lets a user tap an
 * image to make a choice. The app displays a Toast message showing the user’s
 * choice.
 *
 * This version demonstrates various input controls.
 */
class MainActivity : AppCompatActivity() {
    // The order message, displayed in the Toast and sent to the new Activity.
    private var mOrderMessage: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener{
            val intent = Intent(
                this@MainActivity,
                OrderActivity::class.java
            )
            intent.putExtra("EXTRA_MESSAGE", mOrderMessage)
            startActivity(intent)
        }

        donut.setOnClickListener {
                mOrderMessage = getString(R.string.donut_order_message)
                displayToast(mOrderMessage)
        }

        ice_cream.setOnClickListener {
            mOrderMessage = getString(R.string.ice_cream_order_message)
            displayToast(mOrderMessage)
        }

        froyo.setOnClickListener {
            mOrderMessage = getString(R.string.froyo_order_message)
            displayToast(mOrderMessage)
        }

    }

    /**
     * Inflates the menu, and adds items to the action bar if it is present.
     *
     * @param menu Menu to inflate.
     * @return Returns true if the menu inflated.
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    /**
     * Handles app bar item clicks.
     *
     * @param item Item clicked.
     * @return True if one of the defined items was clicked.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // This comment suppresses the Android Studio warning about simplifying
        // the return statements.
        when (item.itemId) {
            R.id.action_order -> {
                displayToast(getString(R.string.action_order_message))
                val intent = Intent(this@MainActivity, OrderActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", mOrderMessage)
                startActivity(intent)
                return true
            }
            R.id.action_status -> {
                displayToast(getString(R.string.action_status_message))
                return true
            }
            R.id.action_favorites -> {
                displayToast(getString(R.string.action_favorites_message))
                return true
            }
            R.id.action_contact -> {
                displayToast(getString(R.string.action_contact_message))
                return true
            }
            else ->{
                return super.onOptionsItemSelected(item)
            }
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