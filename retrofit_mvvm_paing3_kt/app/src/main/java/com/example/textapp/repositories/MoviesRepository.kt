package com.example.textapp.repositories

import com.example.textapp.network.MoviesApi

class MoviesRepository(
    private val moviesApi:MoviesApi
) {
    open fun getMoviesApi():MoviesApi{
        return moviesApi
    }
}
//
//    lateinit var liveDataMovieList: MutableLiveData<List<Result>>
//
//    private val moviesInterface by lazy {
//        MoviesApiClient.create()
//    }
//
//    var disposable: Disposable? = null
//
//    fun getMovieData(page: Int): MutableLiveData<List<Result>> {
//
//        if (!::liveDataMovieList.isInitialized) {
//
//            liveDataMovieList = MutableLiveData()
//            disposable = moviesInterface.getMovies(page)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//
//                    { movies -> liveDataMovieList.value = movies.data
//                        Log.d("repository", "data : ${movies.data}")
//                        Log.d("repository", "livedata : $liveDataMovieList")
//                    },
//
//                    { error -> error.message }
//                )
//
//        }
//        return liveDataMovieList
//
//    }

