package com.example.movieplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieplay.model.Movie
import com.example.movieplay.ui.theme.MoviePlayTheme
import com.example.movieplay.view.MovieItem
import com.example.movieplay.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {

    val movieViewModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviePlayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MovieList(movieList = movieViewModel.movieListResponse)
                    movieViewModel.getMovieList()
                }
            }
        }
    }
}

@Composable
fun MovieList(movieList:List<Movie>){
    LazyColumn{
        itemsIndexed(items = movieList){index, item ->
            MovieItem(movie = item)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoviePlayTheme {
        Greeting("Android")
    }
}