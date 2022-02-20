package com.example.movierecomendation.Presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Domain.home.MoviePostRepo
import com.example.movierecomendation.ui.home.Adapters.MovieAdapter
import kotlinx.coroutines.Dispatchers

class MoviesPostViewModel(private val repo: MoviePostRepo):ViewModel() {
    private lateinit var adapter:MovieAdapter

    fun fetchMoviesRecomendations()= liveData(Dispatchers.IO){
        emit(Result.Loading())
        try {
            emit(repo.getMovies())

            Log.d("viewmodel_1", repo.getMovies().toString())

        }catch(e:Exception){
        emit(Result.Failure(e))
    }

    }

    fun set_score_vm(score:Int, title:String, id_recomendation:Int){
        Log.d("scoreviewmodel",score.toString() + title)
        repo.set_score(score,title,id_recomendation)

    }


    class MoviePostViewmodelFactory(private val repo: MoviePostRepo):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(MoviePostRepo::class.java).newInstance(repo)
        }
    }
}