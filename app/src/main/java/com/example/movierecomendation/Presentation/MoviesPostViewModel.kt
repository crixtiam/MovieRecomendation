package com.example.movierecomendation.Presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Domain.MoviePostRepo
import kotlinx.coroutines.Dispatchers

class MoviesPostViewModel(private val repo:MoviePostRepo):ViewModel() {
    fun fetchMoviesRecomendations()= liveData(Dispatchers.IO){
        emit(Result.Loading())
        try {
            emit(repo.getMovies())
        }catch(e:Exception){
        emit(Result.Failure(e))
    }

    }
}