package com.abhas.letslist.category.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhas.letslist.category.model.Category
import com.abhas.letslist.category.usecase.IGetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    useCase: IGetCategoriesUseCase
): ViewModel() {

    private var _categoriesList = mutableStateOf<List<Category>>(emptyList())
    var categoriesList: State<List<Category>> = _categoriesList
    init {
        viewModelScope.launch {
            var categoryList = useCase().categories
            _categoriesList.value = categoryList
        }
    }
}