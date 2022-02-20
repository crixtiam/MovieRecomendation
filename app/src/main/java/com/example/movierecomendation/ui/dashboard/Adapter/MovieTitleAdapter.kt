package com.example.movierecomendation.ui.dashboard.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movierecomendation.Core.BaseViewHolder
import com.example.movierecomendation.Data.Model.MovieTitleBody
import com.example.movierecomendation.R

import com.example.movierecomendation.databinding.TotalMovieRowBinding
import com.example.movierecomendation.ui.home.Adapters.MovieAdapter

class MovieTitleAdapter (private var movieList: MutableList<MovieTitleBody>, private val itemOnClickListener: MovieTitleAdapter.onClickListener): RecyclerView.Adapter<BaseViewHolder<*>>(){


    interface onClickListener{
        fun onClickListenerFun(identifier: Int,title:String)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = TotalMovieRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
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
        val binding: TotalMovieRowBinding,
        val context: Context
    ): BaseViewHolder<MovieTitleBody>(binding.root){
        override fun bind(item: MovieTitleBody) {
            binding.txtTitulo.text = item.name_movie + item.identifier.toString()


            if (item.flag == 1){
                binding.thumpUp.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24)
            }

            binding.thumpUp.setOnClickListener{
                itemOnClickListener.onClickListenerFun(item.identifier,item.name_movie)
            }


        }
    }









    ///Finnnn
}