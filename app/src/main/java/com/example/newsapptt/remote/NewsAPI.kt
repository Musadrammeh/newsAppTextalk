package com.example.newsapptt.remote

import com.example.newsapptt.data.remote.response.models.News
import com.example.newsapptt.data.remote.response.models.Source
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsAPI {

    @GET("everything")
    suspend fun getArticleList(
        @Query("limit") limit:Int,
        @Query("offset") offset: Int
    ): Call<News>

    @GET("Article")
    suspend fun getNews(
        @Path("News") News: String
    ):Call<News>

    @GET("Source")
    suspend fun getSource(
        @Path("Source") Source: String
    ): Call<Source>

    abstract fun <T> Call(): Nothing
}