package com.example.materialme_starter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*


class SportsAdapter(context: Context?, sportsData: ArrayList<Sport>): RecyclerView.Adapter<SportsAdapter.ViewHolder?>() {

    // Member variables.
    private var mSportsData: ArrayList<Sport>? = sportsData
    private var mContext: Context? = context

    /**
     * ViewHolder class that represents each row of data in the RecyclerView.
     */
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        // Member Variables for the TextViews
        private val mTitleText: TextView = itemView.findViewById(R.id.title)
        private val mInfoText: TextView = itemView.findViewById(R.id.subTitle)
        private val mSportsImage: ImageView = itemView.findViewById(R.id.sportsImage)

        init {
            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }
        fun bindTo(currentSport: Sport) {
            // Populate the textviews with data.
            mTitleText.text = currentSport.getTitle()
            mInfoText.text = currentSport.getInfo()
            Glide.with(itemView).load(currentSport.getImageResource()).into(mSportsImage)
        }

        override fun onClick(v: View?) {
            val currentSport: Sport = mSportsData!![adapterPosition]
            val detailIntent = Intent(mContext, DetailActivity::class.java)
            detailIntent.putExtra("title", currentSport.getTitle())
            detailIntent.putExtra(
                "image_resource",
                currentSport.getImageResource()
            )
            mContext!!.startActivity(detailIntent)
        }
    }

    /**
     * Required method that binds the data to the viewholder.
     *
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        // Get current sport.
        val currentSport = mSportsData!![position]

        // Populate the textviews with data.
        holder.bindTo(currentSport)
    }

    /**
     * Required method for determining the size of the data set.
     *
     * @return Size of the data set.
     */
    override fun getItemCount(): Int {
        return mSportsData!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false))
    }
}