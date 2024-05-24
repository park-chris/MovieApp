package com.crystal.movieapp.features.common.repository

import com.crystal.movieapp.features.common.entity.CategoryEntity
import com.crystal.movieapp.features.common.entity.EntityWrapper
import com.crystal.movieapp.features.common.entity.MovieDetailEntity
import com.crystal.movieapp.features.feed.domain.enum.SortOrder

interface IMovieDataSource {
    suspend fun getCategories(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
    suspend fun getMovieDetail(movieName: String): MovieDetailEntity
}