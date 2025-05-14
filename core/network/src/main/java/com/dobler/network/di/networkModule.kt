package com.dobler.network.di


import com.dobler.network.OkHttpClientFactory
import com.dobler.network.RetrofitFactory
import com.dobler.network.interceptor.ApiKeyInterceptor
import org.koin.dsl.module

val networkModule = module {
    single {ApiKeyInterceptor("")}

    single { OkHttpClientFactory.createOkHttpClient(get()) }
    single { RetrofitFactory.createRetrofit(get()) }
    single { RetrofitFactory.createTmdbApiService(get()) }



}