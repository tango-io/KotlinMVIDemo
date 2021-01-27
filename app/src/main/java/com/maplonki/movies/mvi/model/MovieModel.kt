package com.maplonki.movies.mvi.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
class MovieModel(
    @Json(name="id")
    val id: Long? = null,
    @Json(name="title")
    val title: String? = null,
    @Json(name="overview")
    val overview: String? = null,
    @Json(name="release_date")
    val releaseDate: Date? = null,
    @Json(name="poster_path")
    val coverImage: String? = null,
    @Json(name="backdrop_path")
    val backdropImage: String? = null,
    @Json(name="vote_average")
    val voteAverage: Float? = null,
    @Json(name="vote_count")
    val voteCount: Int? = null
)