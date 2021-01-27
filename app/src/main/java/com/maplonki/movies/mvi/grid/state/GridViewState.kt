package com.maplonki.movies.mvi.grid.state

import com.maplonki.movies.mvi.model.MovieModel

data class GridViewState(
    var movieList: List<MovieModel>? = null
)