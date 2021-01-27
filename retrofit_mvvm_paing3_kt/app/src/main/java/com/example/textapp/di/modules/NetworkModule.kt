package com.example.textapp.di.modules

import com.example.textapp.network.MoviesInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {


    @Provides
    fun provideMoviesService(): MoviesInterface {

        return Retrofit.Builder()
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.create()
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl("https://api.themoviedb.org/3/")
            .build()
            .create(MoviesInterface::class.java)

    }
}


