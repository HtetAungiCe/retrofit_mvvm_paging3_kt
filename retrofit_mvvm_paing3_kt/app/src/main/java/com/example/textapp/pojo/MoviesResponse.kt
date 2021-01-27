package com.example.textapp.pojo

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val page: Int,

    @SerializedName("results")
    val `data` : List<Result>,
    val total_pages: Int,
    val total_results: Int
)