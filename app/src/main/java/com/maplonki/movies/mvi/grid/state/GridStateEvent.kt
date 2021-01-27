package com.maplonki.movies.mvi.grid.state

sealed class GridStateEvent {
    object GetMovies : GridStateEvent()
}