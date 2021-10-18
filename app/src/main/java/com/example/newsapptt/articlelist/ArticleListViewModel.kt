package com.example.newsapptt.articlelist

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.SaveableStateRegistry
import androidx.compose.runtime.snapshots.SnapshotApplyResult
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import coil.request.Parameters
import coil.request.SuccessResult
import com.example.newsapptt.data.remote.response.Article
import com.example.newsapptt.data.remote.response.models.ArticleListEntry
import com.example.newsapptt.remote.NewsAPI
import com.example.newsapptt.repository.NewsRepository
import com.example.newsapptt.util.Constant.PAGE_SIZE
import com.example.newsapptt.util.Resource
import com.google.rpc.context.AttributeContext
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.security.KeyStore
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val repository: NewsAPI
): ViewModel() {

    private var curPage = 0

    var articleList = mutableStateOf<List<ArticleListEntry>>(listOf())
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

