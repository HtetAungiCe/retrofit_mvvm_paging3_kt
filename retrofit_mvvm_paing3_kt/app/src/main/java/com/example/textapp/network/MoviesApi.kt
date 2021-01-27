package com.example.textapp.network

import com.example.textapp.pojo.MoviesResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface MoviesApi {

    @GET("movie/popular?api_key=4db11af8b81b5f51233f56e9078e9c07&language=en-US")
    fun getMoviesData(
        @Query("page") page: Int
    ): Single<MoviesResponse>

    companion object {

        fun create(): MoviesApi {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create()
                )
                .addConverterFactory(
                    GsonConverterFactory.create()
                )
                .baseUrl("https://api.themoviedb.org/3/")
                .build()

            return retrofit.create(MoviesApi::class.java)

        }
    }
}
//    companion object{
//
//        operator fun invoke() : MoviesApi = Retrofit.Builder()
//            .addCallAdapterFactory(
//                RxJava2CallAdapterFactory.create())
//            .addConverterFactory(
//                GsonConverterFactory.create())
//            .baseUrl("https://api.themoviedb.org/3/")
//            .build()
//            .create(MoviesApi::class.java)
//
//    }


