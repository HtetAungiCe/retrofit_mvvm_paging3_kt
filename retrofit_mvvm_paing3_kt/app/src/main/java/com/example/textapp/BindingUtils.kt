package com.example.textapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun imageLoad(view:ImageView,url:String){
    Glide.with(view.context)
        .load("http://image.tmdb.org/t/p/w342$url")
        .into(view)
}