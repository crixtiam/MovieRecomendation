package com.example.movierecomendation.ui.home.Adapters

import android.content.Context
import android.content.DialogInterface
import android.service.carrier.CarrierIdentifier
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movierecomendation.Core.BaseViewHolder
import com.example.movierecomendation.Data.Model.MoviePostServer
import com.example.movierecomendation.databinding.MovieRowBinding

class MovieAdapter(private var movieList: MutableList<MoviePostServer>,private val itemOnClickListener: onClickListener):RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface onClickListener{
        fun onClick(identifier: Int,title:String)
    }

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
            binding.star1.setOnClickListener {
                itemOnClickListener.onClick(1,item.name_movie)
            }

            binding.star2.setOnClickListener {
                itemOnClickListener.onClick(2,item.name_movie)
            }

            binding.star3.setOnClickListener {
                itemOnClickListener.onClick(3,item.name_movie)
            }

            binding.star4.setOnClickListener {
                itemOnClickListener.onClick(4,item.name_movie)
            }

            binding.star5.setOnClickListener {
                itemOnClickListener.onClick(5,item.name_movie)
            }




        }
    }




}



