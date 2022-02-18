package com.example.movierecomendation.Data.Remote

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Data.Model.MoviePostServer

class MoviesDataSource {
    val moviePostServer = mutableListOf<MoviePostServer>()
    suspend fun getMovies(): Result<MutableList<MoviePostServer>> {

        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("recomendations_movies_data")


        return Result.Success(moviePostServer)
    }
}