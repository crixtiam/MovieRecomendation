package com.example.movierecomendation.Presentation

import android.icu.text.CaseMap
import android.text.method.MovementMethod
import android.util.Log
import android.widget.Adapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Domain.MoviePostRepo
import kotlinx.coroutines.Dispatchers

class MoviesPostViewModel(private val repo:MoviePostRepo):ViewModel() {
    fun fetchMoviesRecomendations()= liveData(Dispatchers.Main){
        emit(Result.Loading())
        try {
            emit(repo.getMovies())

            Log.d("viewmodel_1", repo.getMovies().toString())

        }catch(e:Exception){
        emit(Result.Failure(e))
    }

    }

    fun set_score_vm(score:Int, title:String){
        Log.d("scoreviewmodel",score.toString() + title)
        repo.set_score(score,title)

    }


    class MoviePostViewmodelFactory(private val repo:MoviePostRepo):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(MoviePostRepo::class.java).newInstance(repo)
        }
    }
}