package com.example.textapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.textapp.R
import com.example.textapp.databinding.MovieItemBinding
import com.example.textapp.pojo.Result
import javax.inject.Inject


class MovieAdapter @Inject constructor() :
    PagingDataAdapter<Result,MovieAdapter.MovieItemViewHolder>(
        diffCallback = object  : DiffUtil.ItemCallback<Result>() {

            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }
        }
    ) {

    private lateinit var listener:OnItemClickListener
    private lateinit var binding: MovieItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(inflater, R.layout.movie_item, parent, false)
        return MovieItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

     inner class MovieItemViewHolder(itemView: MovieItemBinding) :
        RecyclerView.ViewHolder(itemView.root),
        View.OnClickListener {

        private var binder:MovieItemBinding?=null

        init {
            binder = itemView
            binder?.movieItemContainer?.setOnClickListener(this)
        }

        fun bind(movie: Result?) {
            binder?.movie = movie
        }

         override fun onClick(v: View?) {
             listener.onItemClick(getItem(adapterPosition))
         }
     }

    interface OnItemClickListener {
        fun onItemClick(movie: Result?)
    }

    fun setCallBack(mListener: OnItemClickListener){
        listener = mListener
    }

}

