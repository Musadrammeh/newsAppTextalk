package com.example.newsapptt.articlelist

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.GenericFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.leanback.widget.SearchBar
import androidx.navigation.NavController
import coil.request.ImageRequest
import com.example.newsapptt.R
import com.example.newsapptt.data.remote.response.models.ArticleListEntry
import com.google.accompanist.coil.CoilImage
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
            searchBar(
                hint = "Search article...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){

            }
            Spacer(modifier = Modifier.height(16.dp))
            ArticleList(navController = navController)




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
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    ishintDisplayed
                }
        )
        if(ishintDisplayed){
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)

            )
        }
    }
}
@Composable
fun ArticleList(
    navController: NavController,
    viewModel: ArticleListViewModel = hiltViewModel()
){
    val articleList by remember {viewModel.articleList}

    LazyColumn(contentPadding = PaddingValues(16.dp)){
    }

}

@Composable
fun ArticleListEntry(
    entry: ArticleListEntry,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ArticleListViewModel = hiltViewModel()
){
    val defaultDominantColor = MaterialTheme.colors.surface
    var dominantColor by remember {
        mutableStateOf(defaultDominantColor)
    }

    Box(
        contentAlignment = Center,
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(
                Brush.verticalGradient(
                    listOf(
                        dominantColor,
                        defaultDominantColor
                    )
                )
            )
            .clickable {
                navController.navigate(
                    "news_category_screen${dominantColor.toArgb()}/${entry.articleName}"
                )

            }
    ){
        Column{
            CoilImage(
                request = ImageRequest.Builder(LocalContext.current)
                    .data(entry)
                    .build(),
                contentDescription = entry.articleName,
                modifier = Modifier
                    .size((120.dp))
                    .align(CenterHorizontally)
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.scale(0.5f)

                )
            }
        }
    }
}


@Composable
fun ArticleRow(
    rowIndex: Int,
    entries: List<ArticleListEntry>,
    navController: NavController
){
    Column {
        Row {
            ArticleListEntry(
                entry = entries[rowIndex * 1],
                navController = navController,
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(16.dp))
            if (entries.size >= rowIndex * 1){
                ArticleListEntry(
                    entry = entries[rowIndex * 1],
                    navController = navController,
                    modifier = Modifier.weight(1f)
                )
            } else{
                Spacer(modifier = Modifier.weight(1f) )
            }
        }
        Spacer(modifier = Modifier.height((10.dp)))
    }
}