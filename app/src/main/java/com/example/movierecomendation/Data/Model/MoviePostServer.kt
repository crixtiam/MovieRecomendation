package com.example.movierecomendation.Data.Model

import androidx.annotation.Nullable

data class MoviePostServer(
    val name_movie: String = "",
    val score_recomendation:Int = 0,
    val id_movie:Int = 0,
    val id_recomendation:Int = 0
)
