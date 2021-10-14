package com.example.newsapptt.articlelist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newsapptt.R
import com.google.firebase.database.collection.LLRBNode
import java.time.format.TextStyle

@Composable

fun ArticleListScreen(
    navController: NavController
){
    Surface(
        color = MaterialTheme.colors.background
                //modifier = Modifier.fillMaxSize()
    ){
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(painter = painterResource(id = R.drawable.newslogo),
                contentDescription =  "NewsBreaking",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            )

        }
    }
}
@Composable
fun searchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
){
    var text by remember{
        mutableStateOf("")
    }
    var ishintDisplayed by remember {
        mutableStateOf(hint != "")
    }
    Box(modifier = modifier){
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black)
        )
    }
}