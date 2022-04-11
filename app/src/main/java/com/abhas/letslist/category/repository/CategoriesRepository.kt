package com.abhas.letslist.category.repository

import com.abhas.letslist.category.model.CategoryResponse
import com.abhas.letslist.category.service.IGetCategoriesService
import javax.inject.Inject

interface ICategoriesRepository {
    suspend fun getAllCategories(): CategoryResponse
}

class CategoriesRepository @Inject constructor(
    var service: IGetCategoriesService
): ICategoriesRepository {
    override suspend fun getAllCategories(): CategoryResponse {
        return service.getAllCategories()
    }
}