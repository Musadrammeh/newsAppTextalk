package com.example.newsapptt.articlelist

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapptt.remote.NewsAPI
import com.example.newsapptt.endpoint.Constant.PAGE_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val repository: NewsAPI
): ViewModel() {

    private var curPage = 0

    var articleList = mutableStateOf<List<ArticleListViewModel>>(listOf())
    var isLoading = mutableStateOf(false)

    init{
        loadArticlePaginated()
        Log.d("musa", "init")
    }


   fun loadArticlePaginated() {
       viewModelScope.launch{
           isLoading.value = true
           val result = repository.getArticleList(PAGE_SIZE, curPage * PAGE_SIZE)
           articleList.value
        }
   }
}

