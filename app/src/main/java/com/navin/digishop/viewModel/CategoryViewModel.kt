package com.navin.digishop.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.navin.digishop.models.BaseCategoryModel
import com.navin.digishop.models.DataOrException
import com.navin.digishop.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository) :
    ViewModel() {

    var categories: MutableState<DataOrException<BaseCategoryModel, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, false, null))


    init {
        getCategories()
    }

    fun getCategories() {

        viewModelScope.launch {

            categories.value.loading = true
            categories.value = repository.getCategories()
            if (categories.value.toString().isNotEmpty())
                categories.value.loading = false

        }

    }


}