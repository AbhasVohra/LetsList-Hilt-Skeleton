package com.abhas.letslist.category.service

import com.abhas.letslist.category.model.CategoryResponse
import retrofit2.http.GET

interface IGetCategoriesService {

    @GET("categories.php")
    suspend fun getAllCategories(): CategoryResponse
}