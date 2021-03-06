package com.example.newsapptt.data.remote.response.Articles

import com.example.newsapptt.articlelist.ArticleListViewModel
import com.example.newsapptt.data.remote.response.models.Article
import com.example.newsapptt.data.remote.response.models.News

interface ArticleRepository {
    //Specific Article
    suspend fun getArticle(id: String?): Result<Article>

    //Articles
    suspend fun getArticles(): Result<News>


}