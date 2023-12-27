package com.navin.digishop.di

import com.navin.digishop.network.NetworkApi
import com.navin.digishop.repository.CategoryRepository
import com.navin.digishop.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideDigiApi(): NetworkApi {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        .build().create(NetworkApi::class.java)    }


    @Provides
    @Singleton
    fun provideCategoryRepository(api : NetworkApi) = CategoryRepository(api)

}