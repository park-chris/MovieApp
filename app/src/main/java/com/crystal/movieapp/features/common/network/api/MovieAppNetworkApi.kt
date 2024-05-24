package com.crystal.movieapp.features.common.network.api

import com.crystal.movieapp.features.common.network.model.MovieResponse
import com.crystal.movieapp.library.network.model.ApiResult
import com.crystal.movieapp.library.network.retrofit.NetworkRequestFactory
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class MovieAppNetworkApi @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
): IMovieAppNetworkApi {
    override suspend fun getMovies(): ApiResult<List<MovieResponse>> {
        return networkRequestFactory.create(
            url = "top250.json",
            type = object : TypeToken<List<MovieResponse>>(){}.type
        )
    }
}