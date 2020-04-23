package com.example.scorekeeper

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var mScore1: Int = 0
    private var mScore2: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}
