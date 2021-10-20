package com.example.myquizgame

import com.example.newsapptt.data.remote.response.models.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {
    @GET("https://newsapi.org/v2/everything")
    fun getEverything(
        @Query("everything") everything: String

    ): Call<News>
}

