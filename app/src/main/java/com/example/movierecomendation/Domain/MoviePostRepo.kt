package com.example.movierecomendation.Domain

import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Data.Model.MoviePostServer

interface MoviePostRepo {
    suspend fun getMovies():Result<MutableList<MoviePostServer>>
}