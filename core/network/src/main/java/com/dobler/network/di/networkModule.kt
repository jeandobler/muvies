package com.dobler.network.di


import com.dobler.network.OkHttpClientFactory
import com.dobler.network.RetrofitFactory
import com.dobler.network.interceptor.ApiKeyInterceptor
import org.koin.dsl.module

val networkModule = module {
    single {ApiKeyInterceptor("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmZDg1NzRmYjFhYWNjMGY1ODZmODU1ZjM1ZGQ2N2RkZSIsIm5iZiI6MS41MjY3NDQxMjYzNDA5OTk4ZSs5LCJzdWIiOiI1YjAwNDQzZTBlMGEyNjA5MTUwMDA2YjQiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.voIHNhK7OVUwrdoeGIu1gYvDmh6HUtm6bkha8Khep_Y")}

    single { OkHttpClientFactory.createOkHttpClient(get()) }
    single { RetrofitFactory.createRetrofit(get()) }
    single { RetrofitFactory.createTmdbApiService(get()) }



}