package com.example.movierecomendation.Domain

import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Data.Model.MoviePostServer
import com.example.movierecomendation.Data.Remote.MoviesDataSource

class MoviePostRepoImpo(private val dataSource: MoviesDataSource):MoviePostRepo {
    override suspend fun getMovies():Result<MutableList<MoviePostServer>> = dataSource.getMovies()
    override fun set_score(score: Int, title: String) = dataSource.set_score(score, title)
}