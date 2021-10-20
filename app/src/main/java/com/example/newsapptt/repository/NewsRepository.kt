package com.example.newsapptt.repository

import androidx.compose.ui.input.key.Key.Companion.Call
import com.example.newsapptt.data.remote.response.models.News
import com.example.newsapptt.remote.NewsAPI
import com.example.newsapptt.data.remote.response.Result
import com.example.newsapptt.data.remote.response.models.Article
import com.example.newsapptt.data.remote.response.models.Source
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class NewsRepository @Inject constructor(
    private val api: NewsAPI
){
    suspend fun getArticleList(article: String): Result<Article> {
        val response = try {
            api.Call<Article>()
        }
        catch (e: Exception){
            return Result.Success(Article())
        }
    }
    suspend fun getNews(news: String): Result<News> {
        val result = try {
            api.Call<News>()
        } catch (e: Exception){
            return Result.Success(News())
        }

    }
    suspend fun getSource(source: String): Result.Success<Source> {
        val result = try {
            api.Call<News>()
        } catch (e: Exception){
            return Result.Success(Source())
        }

    }
}