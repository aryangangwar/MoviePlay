package com.example.movieplay.network

import com.example.movieplay.model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("movielist.json")
    suspend fun getMovies() : List<Movie>


    companion object {
        var apiService: ApiService? = null     // variable apiService of type Interface ApiService
        fun getInstance() : ApiService {       // to get instance or create object of type ApiService
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/apis/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }


}