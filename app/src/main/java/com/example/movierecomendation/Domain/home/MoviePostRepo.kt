package com.example.movierecomendation.Domain.home

import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Data.Model.MoviePostServer

interface MoviePostRepo {
    suspend fun getMovies():Result<MutableList<MoviePostServer>>
    fun set_score(score:Int,title:String,id_recomendation:Int)
}