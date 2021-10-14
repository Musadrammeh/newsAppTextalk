package com.example.newsapptt

import android.os.Bundle
import android.widget.Button
import android.widget.HeaderViewListAdapter
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsapptt.articlelist.ArticleListScreen

import com.example.newsapptt.ui.theme.NewsAppTTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent { 
            NewsAppTTTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "article_list_screen"
                ){
                    composable("article_list_screen"){
                        ArticleListScreen(navController = navController)

                    }
                    composable(
                        "news_category_screen/{dominantColor}/{newsName}",
                        arguments = listOf(
                            navArgument("dominantColor"){
                                type = NavType.IntType
                            },
                            navArgument("newsName"){
                                type=NavType.StringType
                            }
                        )

                    ){
                        val dominantColor = remember{
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        val newsName = remember{
                            it.arguments?.getString("newsName")
                        }
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun ComposablePreview() {
        SimpleComposable()
    }
    @Composable
    fun SimpleComposable() {
        Text("Hello World")
    }


}


