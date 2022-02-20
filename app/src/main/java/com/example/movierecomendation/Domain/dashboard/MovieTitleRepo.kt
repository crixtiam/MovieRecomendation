package com.example.movierecomendation.Domain.dashboard

import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Data.Model.MovieTitleBody

interface MovieTitleRepo {
    suspend fun getMovieTitles(): Result<MutableList<MovieTitleBody>>

}