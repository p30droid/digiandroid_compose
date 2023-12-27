package com.navin.digishop.repository

import com.navin.digishop.models.BaseCategoryModel
import com.navin.digishop.models.DataOrException
import com.navin.digishop.network.NetworkApi
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api: NetworkApi) {


    private val dataOrException = DataOrException<BaseCategoryModel, Boolean, Exception>()

    suspend fun getCategories(): DataOrException<BaseCategoryModel, Boolean, Exception> {

        try {
            dataOrException.loading = true

            dataOrException.data = api.getCategories()

            if (dataOrException.data.toString().isNotEmpty())
                dataOrException.loading = false


        } catch (e: Exception) {
            dataOrException.e = e
        }

        return dataOrException
    }


}