package com.example.loadposter.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.loadposter.R
import com.example.loadposter.models.PosterData
import com.squareup.picasso.Picasso

/**
 * RecyclerView adapter to load movie posters and handle poster click event.
 */
class PosterListAdapter(private val posterClickListener: (PosterData) -> Unit) : RecyclerView.Adapter<PosterListAdapter.PosterViewHolder>() {

    var posterList = ArrayList<PosterData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val posterImage = LayoutInflater.from(parent.context).inflate(R.layout.poster_list_item, parent, false)
        return PosterViewHolder(posterImage)
    }

    override fun getItemCount(): Int {
        return posterList.size
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        val posterImageView = holder.itemView.findViewById<ImageView>(R.id.poster_image)
        Picasso.get().load(posterList[position].url).into(posterImageView)
        holder.itemView.setOnClickListener { posterClickListener(posterList[position]) }
    }

    class PosterViewHolder(poster: View) : RecyclerView.ViewHolder(poster)
}