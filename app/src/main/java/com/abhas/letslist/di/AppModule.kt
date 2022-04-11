package com.abhas.letslist.di

import com.abhas.letslist.category.repository.CategoriesRepository
import com.abhas.letslist.category.repository.ICategoriesRepository
import com.abhas.letslist.category.service.IGetCategoriesService
import com.abhas.letslist.category.usecase.GetCategoriesUseCase
import com.abhas.letslist.category.usecase.IGetCategoriesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideIGetCategories(retrofit: Retrofit): IGetCategoriesService {
        return retrofit.create(IGetCategoriesService::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {

        @Binds
        @Singleton
        fun provideGetCategoryRepository(categoriesRepository: CategoriesRepository): ICategoriesRepository

        @Binds
        @Singleton
        fun provideGetCategoryUseCase(getCategoriesUseCase: GetCategoriesUseCase): IGetCategoriesUseCase


    }
}