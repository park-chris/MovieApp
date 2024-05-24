package com.crystal.movieapp.features.feed.domain.usecase

import com.crystal.movieapp.features.common.entity.CategoryEntity
import com.crystal.movieapp.features.common.entity.EntityWrapper
import com.crystal.movieapp.features.feed.domain.enum.SortOrder

interface IGetFeedCategoryUseCase {

    suspend operator fun invoke(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>

}
