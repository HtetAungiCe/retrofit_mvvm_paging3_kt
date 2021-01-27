package com.example.textapp.network

import com.example.textapp.pojo.MoviesResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesInterface {

    @GET("movie/popular?api_key=4db11af8b81b5f51233f56e9078e9c07&language=en-US")
    fun getMovies(
        @Query("page")page:Int
    ):Single<MoviesResponse>

}