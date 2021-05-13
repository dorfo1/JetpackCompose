package com.example.jetpackcompose.data.service

import com.example.jetpackcompose.data.model.MovieDetail
import com.example.jetpackcompose.data.model.MovieList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {


    //TODO - MUDAR PAGE SE QUISER FAZER PAGINAÇÃO
    @GET("popular")
    suspend fun fetchPopularMovies(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "pt-BR"
    ) : MovieList

    @GET("{movie_id}")
    suspend fun fetchMovieDetails(
        @Path("movie_id") movieId : Int,
        @Query("language") language: String = "pt-BR"
    ) : MovieDetail
}