package com.example.movierecomendation.Data.Remote.home

import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Data.Model.MoviePostServer
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.delay


class MoviesDataSource {

    val moviepostserver_list = mutableListOf<MoviePostServer>()
    suspend fun getMovies(): Result<MutableList<MoviePostServer>> {
        delay(500)
        val database = FirebaseDatabase.getInstance().reference


        val listener = object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    moviepostserver_list.clear()
                    for(comments:DataSnapshot in snapshot.children){
                        comments.getValue<MoviePostServer>().let {
                            moviepostserver_list.add(it!!)
                            Log.d("ValueEvent_res",it.name_movie + " -> " + it.score_recomendation.toString())
                        }
                    }
                }else{
                    Log.d("error","Ruta sin datos")
                }

            }

            override fun onCancelled(error: DatabaseError) {
            }

        }

        val databaseReference = database.child("recomendations_movies_data")

        databaseReference.addValueEventListener(listener)
        /*databaseReference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                moviepostserver_list.clear()
                for(comments in snapshot.children){
                    comments.getValue<MoviePostServer>().let {
                        moviepostserver_list.add(it!!)
                        Log.d("ValueEvent_res",it.name_movie + " -> " + it.score_recomendation.toString())
                    }
                } // End if

            }
            // End Function


            override fun onCancelled(error: DatabaseError) {
                Log.d("Error",error.toString())
            }

        })*/

        return Result.Success(moviepostserver_list)
    }



    fun set_score(score:Int, title:String, id_recomendation:Int){
        Log.d("scoredatasource",score.toString() + title)
        val database = Firebase.database
        val myRef = database.getReference("Scores/$title}")
        myRef.setValue(score)
        val path = "recomendations_movies_data/recomendation_$id_recomendation/score_recomendation"
        val database_recomendation = Firebase.database
        val reference_database_recomendation = database_recomendation.getReference(path)
        reference_database_recomendation.setValue(score)
            .addOnSuccessListener {  }
            .addOnFailureListener{}
            .addOnCompleteListener{}
        //mode offline
        //Firebase.database.setPersistenceEnabled(true)
    }

}