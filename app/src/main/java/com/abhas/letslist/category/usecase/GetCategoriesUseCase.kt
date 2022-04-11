package com.abhas.letslist.category.usecase

import com.abhas.letslist.category.model.CategoryResponse
import com.abhas.letslist.category.repository.ICategoriesRepository
import javax.inject.Inject

interface IGetCategoriesUseCase {
    suspend operator fun invoke(): CategoryResponse
}

class GetCategoriesUseCase @Inject constructor(
    var repository: ICategoriesRepository
): IGetCategoriesUseCase {
    override suspend fun invoke(): CategoryResponse {
        return repository.getAllCategories()
    }
}