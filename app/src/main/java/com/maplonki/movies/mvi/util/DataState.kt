package com.maplonki.movies.mvi.util

data class DataState<T>(
    var error: String? = null,
    var isLoading: Boolean = false,
    var data: T? = null
) {

    companion object {
        fun <T> error(error: String, data: T? = null) =
            DataState(error, false, data)


        fun <T> loading(isLoading: Boolean) =
            DataState<T>(null, isLoading, null)

        fun <T> data(data: T, error: String? = null) =
            DataState(error, false, data)
    }
}