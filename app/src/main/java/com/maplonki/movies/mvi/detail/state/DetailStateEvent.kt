package com.maplonki.movies.mvi.detail.state

sealed class DetailStateEvent {
    data class GetMovieDetail(val movieid: String) : DetailStateEvent()
}