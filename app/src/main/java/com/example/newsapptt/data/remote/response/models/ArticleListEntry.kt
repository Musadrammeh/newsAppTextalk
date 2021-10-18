package com.example.newsapptt.data.remote.response.models

data class ArticleListEntry(
    val articleName: String,
    val imageURL: String,
    val number: Int,
    val entry: ArticleListEntry?
)


