package com.example.movierecomendation.Presentation.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Data.Model.MovieTitleBody
import com.example.movierecomendation.Domain.dashboard.MovieTitleRepo
import com.example.movierecomendation.Domain.home.MoviePostRepo
import kotlinx.coroutines.Dispatchers

class MoviesTotalViewModel(private val repo: MovieTitleRepo):ViewModel() {

    fun fetchTotalMovies()= liveData(Dispatchers.IO){
        emit(Result.Loading())
        try {
            emit(repo.getMovieTitles())


        }catch(e:Exception){
            emit(Result.Failure(e))
        }

    }


    class MoviesTotalViewmodelFactory(private val repo: MovieTitleRepo): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(MovieTitleRepo::class.java).newInstance(repo)
        }
    }



}