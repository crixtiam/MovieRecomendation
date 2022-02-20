package com.example.movierecomendation.Data.Remote.dashboard

import android.util.Log
import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Data.Model.MoviePostServer
import com.example.movierecomendation.Data.Model.MovieTitleBody
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.delay

class DatasourceDashboard {
    val movie_total_list = mutableListOf<MovieTitleBody>()
    suspend fun getMovieTitles(): Result<MutableList<MovieTitleBody>> {
        delay(2000)
        val database = FirebaseDatabase.getInstance().reference


        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    Log.d("entro","entro")
                    movie_total_list.clear()
                    for(movies: DataSnapshot in snapshot.children){
                         movies.getValue<MovieTitleBody>().let {
                            movie_total_list.add(it!!)
                        }
                    }
                }else{
                    Log.d("error","Ruta sin datos")
                }

            }

            override fun onCancelled(error: DatabaseError) {
            }

        }

        val databaseReference = database.child("movie_title")

        databaseReference.addValueEventListener(listener)
        return Result.Success(movie_total_list)
    }
}