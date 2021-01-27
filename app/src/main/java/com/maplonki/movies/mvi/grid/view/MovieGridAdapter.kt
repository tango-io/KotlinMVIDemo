package com.maplonki.movies.mvi.grid.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.maplonki.movies.mvi.R
import com.maplonki.movies.mvi.extensions.loadImage
import com.maplonki.movies.mvi.model.MovieModel
import com.maplonki.movies.mvi.util.Constants

class MovieGridAdapter : RecyclerView.Adapter<MovieGridAdapter.ViewHolder>() {

    var movieList: List<MovieModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cell_movie_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        fun bind(movie: MovieModel) {
            val imageUrl = Constants.BASE_IMAGE_URL + movie.coverImage
            itemView.findViewById<ImageView>(R.id.cell_movie_image).loadImage(imageUrl)
        }
    }

    override fun getItemCount() = movieList.size
}