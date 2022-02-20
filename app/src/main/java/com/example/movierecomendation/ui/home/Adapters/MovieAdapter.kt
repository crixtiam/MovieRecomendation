package com.example.movierecomendation.ui.home.Adapters

import android.content.Context
import android.content.DialogInterface
import android.service.carrier.CarrierIdentifier
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.movierecomendation.Core.BaseViewHolder
import com.example.movierecomendation.Data.Model.MoviePostServer
import com.example.movierecomendation.R
import com.example.movierecomendation.databinding.MovieRowBinding

class MovieAdapter(private var movieList: MutableList<MoviePostServer>,private val itemOnClickListener: onClickListener):RecyclerView.Adapter<BaseViewHolder<*>>() {
    interface onClickListener{
        fun onClick(identifier: Int,title:String,id_recomendation:Int)
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
            when(item.score_recomendation){
                0 ->{
                }

                1->{
                    binding.star1.setImageResource(R.drawable.ic_baseline_star_24)

                }
                2->{
                    binding.star1.setImageResource(R.drawable.ic_baseline_star_24)
                    binding.star2.setImageResource(R.drawable.ic_baseline_star_24)
                }
                3->{
                    binding.star1.setImageResource(R.drawable.ic_baseline_star_24)
                    binding.star2.setImageResource(R.drawable.ic_baseline_star_24)
                    binding.star3.setImageResource(R.drawable.ic_baseline_star_24)

                }
                4->{
                    binding.star1.setImageResource(R.drawable.ic_baseline_star_24)
                    binding.star2.setImageResource(R.drawable.ic_baseline_star_24)
                    binding.star3.setImageResource(R.drawable.ic_baseline_star_24)
                    binding.star4.setImageResource(R.drawable.ic_baseline_star_24)

                }
                5->{
                    binding.star1.setImageResource(R.drawable.ic_baseline_star_24)
                    binding.star2.setImageResource(R.drawable.ic_baseline_star_24)
                    binding.star3.setImageResource(R.drawable.ic_baseline_star_24)
                    binding.star4.setImageResource(R.drawable.ic_baseline_star_24)
                    binding.star5.setImageResource(R.drawable.ic_baseline_star_24)

                }
            }



            binding.star1.setOnClickListener {
                itemOnClickListener.onClick(1,item.name_movie,item.id_recomendation)
            }

            binding.star2.setOnClickListener {
                itemOnClickListener.onClick(2,item.name_movie,item.id_recomendation)
            }

            binding.star3.setOnClickListener {
                itemOnClickListener.onClick(3,item.name_movie,item.id_recomendation)
            }

            binding.star4.setOnClickListener {
                itemOnClickListener.onClick(4,item.name_movie,item.id_recomendation)
            }

            binding.star5.setOnClickListener {
                itemOnClickListener.onClick(5,item.name_movie,item.id_recomendation)
            }




        }
    }




}



