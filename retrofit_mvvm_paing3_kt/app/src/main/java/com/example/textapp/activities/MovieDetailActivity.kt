package com.example.textapp.activities

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.textapp.R
import com.example.textapp.databinding.MovieDetailActivityBinding

class MovieDetailActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var binding: MovieDetailActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.movie_detail_activity)

        binding.detailName = intent.getStringExtra("name")
        binding.detailDate = intent.getStringExtra("date")
        binding.detailLanguage = intent.getStringExtra("language")
        binding.content = intent.getStringExtra("content")
        binding.imgUrl = intent.getStringExtra("imgUrl")
        binding.btnBackArrow.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        onBackPressed()
    }
}