package com.example.newsapptt.data.remote.response.models

import com.example.newsapptt.data.remote.response.models.Source
import com.google.gson.annotations.SerializedName


data class Article(
    @SerializedName("author")
    val author: String? = "",
    @SerializedName("content")
    val content: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("publishedAt")
    val publishedAt: String? = "",
    @SerializedName("source")
    val source: Source? = Source(),
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("urlToImage")
    val urlToImage: String? = ""
)

data class News(
    @SerializedName("articles")
    val articles: List<Article>? = listOf(),
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("totalResults")
    val totalResults: Int? = 0
)

data class Source(
    @SerializedName("id")
    val id: Any? = Any(),
    @SerializedName("name")
    val name: String? = ""
)