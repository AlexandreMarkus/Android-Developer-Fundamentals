package com.example.scorekeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

const val STATE_SCORE_1 = "Team 1 Score"
const val STATE_SCORE_2 = "Team 2 Score"

class MainActivity : AppCompatActivity() {
    private var mScore1: Int = 0
    private var mScore2: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            score_1.text = mScore1.toString()
            score_2.text = mScore2.toString()
        }
    }

    /**
     * Method that handles the onClick of both the decrement buttons
     * @param view The button view that was clicked
     */
    fun decreaseScore(view: View) {
        // Get the ID of the button that was clicked
        when (view.id) {
             decreaseTeam1.id -> {
                //Decrement the score and update the TextView
                mScore1--
                 score_1.text = mScore1.toString()
            }
            decreaseTeam2.id -> {
                //Decrement the score and update the TextView
                mScore2--
                score_2.text = mScore2.toString()
            }
        }
    }

    /**
     * Method that handles the onClick of both the increment buttons
     * @param view The button view that was clicked
     */
    fun increaseScore(view: View) {
        //Get the ID of the button that was clicked
        when (view.id) {
            increaseTeam1.id -> {
                //Increment the score and update the TextView
                mScore1++
                score_1.text = mScore1.toString()
            }
            increaseTeam2.id -> {
                //Increment the score and update the TextView
                mScore2++
                score_2.text = mScore2.toString()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Check if the correct item was clicked
        if(item.itemId==R.id.night_mode) {
            // Get the night mode state of the app.
            val nightMode: Int = AppCompatDelegate.getDefaultNightMode()
            //Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }

        }
// Recreate the activity for the theme change to take effect.
            recreate();
            return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app.
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu!!.findItem(R.id.night_mode).setTitle(R.string.day_mode)
        } else {
            menu!!.findItem(R.id.night_mode).setTitle(R.string.night_mode)
        }
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }
}
