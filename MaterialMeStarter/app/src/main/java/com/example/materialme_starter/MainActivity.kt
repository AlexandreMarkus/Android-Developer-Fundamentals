package com.example.materialme_starter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


/***
 * Main Activity for the Material Me app, a mock sports news application
 * with poor design choices.
 */
class MainActivity : AppCompatActivity() {
    // Member variables.
    private var mSportsData: ArrayList<Sport>? = null
    private var mAdapter: SportsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the RecyclerView.
        // Set the Layout Manager.
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the ArrayList that will contain the data.
        mSportsData = ArrayList<Sport>()

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = SportsAdapter(this, mSportsData!!)
        recyclerView!!.adapter = mAdapter

        // Get the data.
        initializeData()

        val helper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or ItemTouchHelper.DOWN or ItemTouchHelper.UP, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition
                Collections.swap(mSportsData, from, to)
                mAdapter!!.notifyItemMoved(from, to)
                return true
            }

            override fun onSwiped(
                viewHolder: RecyclerView.ViewHolder,
                direction: Int
            ) {
                mSportsData!!.removeAt(viewHolder.adapterPosition)
                mAdapter!!.notifyItemRemoved(viewHolder.adapterPosition)
            }
        })

        helper.attachToRecyclerView(recyclerView)
    }

    /**
     * Initialize the sports data from resources.
     */
    private fun initializeData() {
        // Get the resources from the XML file.
        val sportsList: Array<String> = resources.getStringArray(R.array.sports_titles)
        val sportsInfo: Array<String> = resources.getStringArray(R.array.sports_info)
        val sportsImageResources = resources.obtainTypedArray(R.array.sports_images)
        // Clear the existing data (to avoid duplication).
        mSportsData!!.clear()

        // Create the ArrayList of Sports objects with titles and
        // information about each sport.
        for (i in sportsList.indices) {
            mSportsData!!.add(Sport(sportsList[i], sportsInfo[i], sportsImageResources.getResourceId(i,0)))
        }

        sportsImageResources.recycle()
        // Notify the adapter of the change.
        recyclerView!!.adapter?.notifyDataSetChanged()
    }
}