package com.example.textapp.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.textapp.network.MoviesApi
import com.example.textapp.network.MoviesInterface
import com.example.textapp.paging.DataPagingSource
import com.example.textapp.pojo.Result
import com.example.textapp.repositories.MoviesRepository
import javax.inject.Inject


class MovieViewModel @Inject constructor(
   private val moviesApi: MoviesInterface
) : ViewModel() {
    val listData = Pager(
        config = PagingConfig(pageSize = 1),
        pagingSourceFactory = { DataPagingSource(moviesApi) }
    ).flow.cachedIn(viewModelScope)

}

