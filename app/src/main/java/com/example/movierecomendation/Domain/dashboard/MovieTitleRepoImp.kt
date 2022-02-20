package com.example.movierecomendation.Domain.dashboard

import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Data.Model.MoviePostServer
import com.example.movierecomendation.Data.Model.MovieTitleBody
import com.example.movierecomendation.Data.Remote.dashboard.DatasourceDashboard

class MovieTitleRepoImp(private val datasource:DatasourceDashboard):MovieTitleRepo {
    override suspend fun getMovieTitles():Result<MutableList<MovieTitleBody>> = datasource.getMovieTitles()
}