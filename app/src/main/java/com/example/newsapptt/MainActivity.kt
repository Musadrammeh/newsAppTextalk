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

import com.example.newsapptt.ui.theme.NewsAppTTTheme

data class NewsSite(
    val id: Int,
    val section: Int,
    val name: String,
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val newsSites = arrayListOf<NewsSite>()
        var section = 1

        for (i in 1..100){

            if (i % 15 == 0)
                section++
            newsSites.add(
                NewsSite(
                    id = i,
                    section = section,
                    name = "NEWS",


                )
            )
        }

        setContent {
            NewsAppTTTheme {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun NewsApp(Unit: () -> Unit){
    NewsAppTTTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Unit()
        }
    }
}
@Composable
fun AppName(String: HeaderViewListAdapter){

}

// Show message multiple times without duplicating code
@Composable
fun MyScreenContent(names: List<String> = List(100){"Click Newspaper of Choice $it"}){
    Column (modifier = Modifier.fillMaxHeight()){
        Divider(color = Color.Gray, thickness = 1.dp)
        NewsList(names = names, modifier = Modifier.weight(1f))
        Button()

    }
    
}

@Composable
fun NewsList(names: List<String>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(items = names){
            Greeting(name = it)
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Composable
fun Button(){
    var button by  remember {
        mutableStateOf(0)
    }
    Button(onClick = { button }) {
        Text(text = "Click to start reading Newspaper of choice",
            fontSize = 15.sp,
            modifier = Modifier.padding(8.dp))

    }
}

@Composable
fun Greeting(name: String) {
    var isSelected by remember{
        mutableStateOf(false)
    }
    val targetColor : Color by animateColorAsState(
        targetValue= if (isSelected) MaterialTheme.colors.primary else Color.Transparent,
            )
    Surface(color = targetColor) {
        Text(
            text = "Hello, $name!",
            modifier = Modifier
                .clickable { isSelected = !isSelected }
                .padding(16.dp)

        )
        
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsAppTTTheme {
        MyScreenContent()
    }
}