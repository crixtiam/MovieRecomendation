package com.example.movierecomendation.Domain.home

import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Data.Model.MoviePostServer
import com.example.movierecomendation.Data.Remote.home.MoviesDataSource
import com.example.movierecomendation.Domain.home.MoviePostRepo

class MoviePostRepoImpo(private val dataSource: MoviesDataSource): MoviePostRepo {
    override suspend fun getMovies():Result<MutableList<MoviePostServer>> = dataSource.getMovies()
    override fun set_score(score: Int, title: String,id_recomendation:Int) = dataSource.set_score(score, title,id_recomendation)
}