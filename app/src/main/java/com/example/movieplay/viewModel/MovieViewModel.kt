package com.example.movieplay.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieplay.model.Movie
import com.example.movieplay.network.ApiService
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    var movieListResponse : List<Movie> by mutableStateOf(listOf())   // so that Compose can automatically recompose when the state changes.
    var errorMessage : String by mutableStateOf("")  // so that Compose can automatically recompose when the state changes.

    fun getMovieList(){
        viewModelScope.launch {
            val apiService  = ApiService.getInstance()  // create the object of the apiService
            try{
                val movieList = apiService.getMovies()
                movieListResponse = movieList
            }catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}