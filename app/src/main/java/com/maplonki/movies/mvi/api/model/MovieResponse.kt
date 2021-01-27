package com.maplonki.movies.mvi.api.model

import com.maplonki.movies.mvi.model.MovieModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<MovieModel>
)