package com.maplonki.movies.mvi.detail

import androidx.lifecycle.LiveData
import com.maplonki.movies.mvi.BuildConfig
import com.maplonki.movies.mvi.api.MyRetrofitBuilder
import com.maplonki.movies.mvi.detail.state.DetailViewState
import com.maplonki.movies.mvi.model.MovieModel
import com.maplonki.movies.mvi.util.ApiSuccessResponse
import com.maplonki.movies.mvi.util.DataState
import com.maplonki.movies.mvi.util.GenericApiResponse
import com.maplonki.movies.mvi.util.NetworkBoundResource

object DetailRepository {

    val API_KEY = BuildConfig.API_KEY

    fun getMovieDetail(movieId: String): LiveData<DataState<DetailViewState>> {
        return object : NetworkBoundResource<MovieModel, DetailViewState>() {
            override fun handleApiSuccessResponse(response: ApiSuccessResponse<MovieModel>) {
                result.value = DataState.data(
                    data = DetailViewState(
                        movie = response.body
                    )
                )
            }

            override fun createCall(): LiveData<GenericApiResponse<MovieModel>> {
                return MyRetrofitBuilder.apiService.getMovieDetail(
                    movieId = movieId,
                    apiKey = API_KEY
                )
            }

        }.asLiveData()
    }
}
