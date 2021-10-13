package com.example.newsapptt.remote

import com.example.newsapptt.data.remote.response.Article
import com.example.newsapptt.data.remote.response.News
import com.example.newsapptt.data.remote.response.Source
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsAPI {

    @GET("Article")
    suspend fun getArticleList(
        @Query("limit") limit:Int,
        @Query("offset") offset: Int
    ): Article

    @GET("Article/{News}")
    suspend fun getNews(
        @Path("News") News: String
    ):News

    @GET("Article/{Source}")
    suspend fun getSource(
        @Path("Source") Source: String
    ): Source
}