package com.maplonki.movies.mvi.api

import androidx.lifecycle.LiveData
import com.maplonki.movies.mvi.api.model.MovieResponse
import com.maplonki.movies.mvi.util.GenericApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/{filter}")
    fun getMovies(
        @Path("filter") filter: String = "popular",
        @Query("api_key") apiKey: String
    ): LiveData<GenericApiResponse<MovieResponse>>
}