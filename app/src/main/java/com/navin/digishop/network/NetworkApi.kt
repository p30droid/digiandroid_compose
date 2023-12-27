package com.navin.digishop.network

import com.navin.digishop.models.BaseCategoryModel
import retrofit2.http.GET

interface NetworkApi {

    @GET("getCategories.php")
    suspend fun getCategories(): BaseCategoryModel


}