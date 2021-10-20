package com.example.newsapptt.endpoint

import com.example.newsapptt.remote.NewsAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constant {
    const val BASE_URL = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=API_KEY"

    const val PAGE_SIZE = 70

    val instance: NewsAPI by lazy {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        retrofit.create(NewsAPI::class.java)
    }
    val instanceTwo: NewsAPI by lazy {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        retrofit.create(NewsAPI::class.java)
    }
}
