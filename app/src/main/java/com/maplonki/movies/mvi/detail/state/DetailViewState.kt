package com.maplonki.movies.mvi.detail.state

import com.maplonki.movies.mvi.model.MovieModel

data class DetailViewState(
    var movie: MovieModel? = null
)