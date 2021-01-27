package com.maplonki.movies.mvi.repository

import androidx.lifecycle.LiveData
import com.maplonki.movies.mvi.BuildConfig
import com.maplonki.movies.mvi.api.MyRetrofitBuilder
import com.maplonki.movies.mvi.api.model.MovieResponse
import com.maplonki.movies.mvi.grid.state.GridViewState
import com.maplonki.movies.mvi.util.*

object MainRepository {

    val API_KEY = BuildConfig.API_KEY

    fun getMovies(): LiveData<DataState<GridViewState>> {
        return object : NetworkBoundResource<MovieResponse, GridViewState>() {
            override fun handleApiSuccessResponse(response: ApiSuccessResponse<MovieResponse>) {
                result.value = DataState.data(
                    data = GridViewState(
                        movieList = response.body.results
                    )
                )
            }

            override fun createCall(): LiveData<GenericApiResponse<MovieResponse>> {
                return MyRetrofitBuilder.apiService.getMovies(apiKey = API_KEY)
            }

        }.asLiveData()
    }
}