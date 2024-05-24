package com.crystal.movieapp.features.detail.domain.usecase

import com.crystal.movieapp.features.common.entity.MovieDetailEntity

interface IGetMovieDetailUseCase {
    suspend operator fun invoke(name: String): MovieDetailEntity
}