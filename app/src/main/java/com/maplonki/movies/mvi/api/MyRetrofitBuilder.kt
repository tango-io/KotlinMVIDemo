package com.maplonki.movies.mvi.api

import androidx.lifecycle.LiveData
import com.maplonki.movies.mvi.util.Constants.BASE_URL
import com.maplonki.movies.mvi.util.LiveDataCallAdapter
import com.maplonki.movies.mvi.util.LiveDataCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

object MyRetrofitBuilder {

    val moshi: Moshi = Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter())
        .build()

    val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
    }


    val apiService: MovieService by lazy {
        retrofitBuilder
            .build()
            .create(MovieService::class.java)
    }
}