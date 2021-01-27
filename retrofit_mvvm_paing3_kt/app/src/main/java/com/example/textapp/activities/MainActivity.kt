package com.example.textapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.textapp.R
import com.example.textapp.adapters.MovieAdapter
import com.example.textapp.databinding.ActivityMainBinding
import com.example.textapp.di.components.MyApplication
import com.example.textapp.paging.MoviesLoadStateAdapter
import com.example.textapp.pojo.Result
import com.example.textapp.viewmodels.MovieViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MovieAdapter.OnItemClickListener {

    @Inject lateinit var adapter: MovieAdapter
    @Inject lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapterSetUp()
    }

    private fun adapterSetUp() {
        adapter.setCallBack(this)
        adapter.addLoadStateListener { loadStates ->
            binding.isLoading = loadStates.refresh is LoadState.Loading
                  }
        lifecycleScope.launch {
            movieViewModel.listData.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
        binding.rvMain.adapter = adapter.withLoadStateHeaderAndFooter(
            header = MoviesLoadStateAdapter { adapter.retry() },
            footer = MoviesLoadStateAdapter { adapter.retry() }
        )
    }

    override fun onItemClick(movie: Result?) {
        Toast.makeText(
            this,
            "you clicked this title : ${movie?.title}",
            Toast.LENGTH_SHORT
        ).show()
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("name", movie?.title)
        intent.putExtra("language", movie?.original_language)
        intent.putExtra("date", movie?.release_date)
        intent.putExtra("imgUrl", movie?.poster_path)
        intent.putExtra("content", movie?.overview)
        startActivity(intent)
    }
}
// ViewModel Create With Factory for api parameter
//   movieViewModel = ViewModelProvider(
//            this,
//            MoviesViewModelFactory(MoviesApi.create())
//        )[MovieViewModel::class.java]
