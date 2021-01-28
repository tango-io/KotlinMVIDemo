package com.maplonki.movies.mvi.extensions

import android.content.Context
import com.maplonki.movies.mvi.R
import com.maplonki.movies.mvi.model.MovieModel
import com.maplonki.movies.mvi.util.Constants
import java.text.SimpleDateFormat
import java.util.*


fun MovieModel.releaseDateFormatted(context: Context): String {
    val formattedDate: String =
        SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(releaseDate ?: Date())
    return String.format(context.getString(R.string.release_date_format), formattedDate)
}

fun MovieModel.ratingFormatted(context: Context): String {
    return String.format(
        context.getString(R.string.rating_format), voteAverage?.toInt() ?: 0
    )
}

fun MovieModel.fullCover() = Constants.BASE_IMAGE_URL + backdropImage

fun MovieModel.fullPoster() = Constants.BASE_IMAGE_URL + coverImage
