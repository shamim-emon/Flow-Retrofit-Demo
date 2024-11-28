package com.example.flow.retrofit.demo.di

import com.example.flow.retrofit.demo.repository.ApiHelper
import com.example.flow.retrofit.demo.repository.ApiHelperImpl
import com.example.flow.retrofit.demo.repository.ApiService
import com.example.flow.retrofit.demo.repository.Repository
import com.example.flow.retrofit.demo.repository.RepositoryImpl
import com.example.flow.retrofit.demo.repository.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRetrofitBuilder(converterFactory: GsonConverterFactory): RetrofitBuilder = RetrofitBuilder(converterFactory)

    @Provides
    fun provideApiService(retrofitBuilder: RetrofitBuilder): ApiService = retrofitBuilder.getRetrofit().create(ApiService::class.java)

    @Provides
    fun provideApiHelper(apiService: ApiService): ApiHelper = ApiHelperImpl(apiService)

    @Provides
    fun provideRepository(apiHelper: ApiHelper): Repository = RepositoryImpl(apiHelper)

    @Provides
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO

}