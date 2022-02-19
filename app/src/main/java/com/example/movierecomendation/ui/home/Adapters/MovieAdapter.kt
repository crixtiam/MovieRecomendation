package com.example.movierecomendation.ui.home.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movierecomendation.Core.BaseViewHolder
import com.example.movierecomendation.Data.Model.MoviePostServer
import com.example.movierecomendation.databinding.MovieRowBinding

class MovieAdapter(private var movieList: MutableList<MoviePostServer>):RecyclerView.Adapter<BaseViewHolder<*>>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =  MovieRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(itemBinding,parent.context)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder){

            is MovieViewHolder->{
                holder.bind(movieList[position])
            }

        }
    }



    private inner class MovieViewHolder(
        val binding: MovieRowBinding,
        val context: Context
    ):BaseViewHolder<MoviePostServer>(binding.root){
        override fun bind(item: MoviePostServer) {

            binding.txtTitulo.text = item.name_movie
        }
    }

}