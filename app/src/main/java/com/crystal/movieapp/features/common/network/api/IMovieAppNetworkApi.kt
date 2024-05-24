package com.crystal.movieapp.features.common.network.api

import com.crystal.movieapp.features.common.network.model.MovieResponse
import com.crystal.movieapp.library.network.model.ApiResult

interface IMovieAppNetworkApi {
    suspend fun getMovies(): ApiResult<List<MovieResponse>>

}