package com.crystal.movieapp.features.detail.domain.usecase

import com.crystal.movieapp.features.common.entity.MovieDetailEntity
import com.crystal.movieapp.features.common.repository.IMovieDataSource
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val dataSource: IMovieDataSource
) : IGetMovieDetailUseCase {
    override suspend fun invoke(name: String): MovieDetailEntity {
        return dataSource.getMovieDetail(name)
    }
}