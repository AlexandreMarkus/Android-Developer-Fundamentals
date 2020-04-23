package com.example.recyclerview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private var mAdapter: WordListAdapter? = null
    private var mWordList: LinkedList<String> = LinkedList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Put initial data into the word list.
        for (i in 0..19) {
            mWordList.addLast("Word $i")
        }

// Create an adapter and supply the data to be displayed.
        mAdapter = WordListAdapter(this, mWordList)
// Connect the adapter with the RecyclerView.
        recycler_view.adapter = mAdapter
// Give the RecyclerView a default layout manager.
        recycler_view.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener {
            val wordListSize = mWordList.size
            // Add a new word to the wordList.
            mWordList.addLast("+ Word $wordListSize")
            // Notify the adapter, that the data has changed.
            recycler_view.adapter?.notifyItemInserted(wordListSize)
            // Scroll to the bottom.
            recycler_view.smoothScrollToPosition(wordListSize)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
