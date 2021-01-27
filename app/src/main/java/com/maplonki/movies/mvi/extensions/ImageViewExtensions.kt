package com.maplonki.movies.mvi.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.maplonki.movies.mvi.R

fun ImageView.loadImage(imagePath: String?) {
    Glide.with(context)
        .load(imagePath)
        .fallback(R.drawable.ic_image_fallback)
        .into(this)
}