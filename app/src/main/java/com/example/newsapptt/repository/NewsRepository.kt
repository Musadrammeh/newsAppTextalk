package com.example.newsapptt.repository

import com.example.newsapptt.data.remote.response.Article
import com.example.newsapptt.data.remote.response.News
import com.example.newsapptt.data.remote.response.Source
import com.example.newsapptt.remote.NewsAPI
import com.example.newsapptt.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class NewsRepository @Inject constructor(
    private val api: NewsAPI
){
    suspend fun getArticleList(limit: Int, offset: Int): Resource<Article> {
        val response = try {
            api.getArticleList(limit, offset)
        } catch (e: Exception){
            return Resource.Error("Error loading article")
        }
        return Resource.Success(response)
    }
    suspend fun getNews(news: String): Resource<News> {
        val response = try {
            api.getNews(news)
        } catch (e: Exception){
            return Resource.Error("Error loading news")
        }
        return Resource.Success(response)
    }
    suspend fun getSource(source: String): Resource<Source> {
        val response = try {
            api.getSource(source)
        } catch (e: Exception){
            return Resource.Error("Error loading news")
        }
        return Resource.Success(response)
    }
}