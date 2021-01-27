package com.example.textapp.paging

import androidx.paging.rxjava2.RxPagingSource
import com.example.textapp.network.MoviesApi
import com.example.textapp.network.MoviesInterface
import com.example.textapp.pojo.MoviesResponse
import com.example.textapp.pojo.Result
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class DataPagingSource(
    private val moviesApi: MoviesInterface
) : RxPagingSource<Int, Result>() {
    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Result>> {
        val page = params.key ?: 1

        return moviesApi.getMovies(page)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map { toLoadResult(it, page) }

    }

    private fun toLoadResult(it: MoviesResponse, page: Int): LoadResult<Int, Result> {
        return LoadResult.Page(
            data = it.data ,
            prevKey = if (page == 1) null else page - 1,
            nextKey = if (it.data.isEmpty()) null else page + 1
        )
    }

//        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
//
//            return try {
//                val page = params.key ?: 1
//
//                val dataList = moviesApi.getMoviesData(page)
//                Log.d("pagingAdapter","page $page")
//                Log.d("pagingAdapter","data $dataList")
//
//                LoadResult.Page(
//                    data = dataList,
//                    prevKey = if (page == 1) null else page - 1 ,
//                    nextKey = if (dataList.isEmpty()) null else page + 1
//
//                )
//
//            } catch (exception: Exception) {
//
//                LoadResult.Error(exception)
//            }
//
//        }

}



