package com.example.recyclerview


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class WordListAdapter(context: Context?,wordList: LinkedList<String>) : RecyclerView.Adapter<WordListAdapter.WordViewHolder?>() {
    private var mWordList: LinkedList<String>? = wordList
    private var mInflater: LayoutInflater? = LayoutInflater.from(context)

    class WordViewHolder(itemView: View, adapter: WordListAdapter?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var wordItemView: TextView? = itemView.findViewById(R.id.word)
        private var mAdapter: WordListAdapter? = adapter
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            // Get the position of the item that was clicked.
            val mPosition = layoutPosition
            // Use that to access the affected item in mWordList.
            val element: String = mAdapter!!.mWordList!![mPosition]
            // Change the word in the mWordList.
            mAdapter!!.mWordList!![mPosition] = "Clicked! $element"
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter!!.notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val mItemView: View = mInflater!!.inflate(R.layout.wordlist_item, parent, false)
        return WordViewHolder(mItemView, this )
    }

    override fun getItemCount(): Int {
        return mWordList?.size!!
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val mCurrent: String = mWordList!![position]
        holder.wordItemView!!.text = mCurrent
    }
}