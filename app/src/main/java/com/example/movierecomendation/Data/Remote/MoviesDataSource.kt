package com.example.movierecomendation.Data.Remote

import android.annotation.SuppressLint
import android.graphics.Movie
import android.util.Log
import androidx.collection.arrayMapOf
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Data.Model.MoviePostServer
import com.example.movierecomendation.ui.home.Adapters.MovieAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.newFixedThreadPoolContext

class MoviesDataSource {
    val moviepostserver_list = mutableListOf<MoviePostServer>()
    private lateinit var Adapter : MovieAdapter

    suspend fun getMovies(): Result<MutableList<MoviePostServer>> {
        val database = FirebaseDatabase.getInstance().reference
        database.keepSynced(true)
        val databaseReference = database.child("recomendations_movies_data")

        databaseReference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                moviepostserver_list.clear()
                for(comments in snapshot.children){
                    comments.getValue<MoviePostServer>().let {
                        moviepostserver_list.add(it!!)
                        Log.d("ValueEvent_res",it.name_movie)


                    }
                } // End if

            }
            // End Function


            override fun onCancelled(error: DatabaseError) {
                Log.d("Error",error.toString())
            }

        })

        return Result.Success(moviepostserver_list)
    }
}