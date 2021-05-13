package com.example.jetpackcompose.data.repository

import com.example.jetpackcompose.core.base.Resource
import com.example.jetpackcompose.data.model.Movie
import com.example.jetpackcompose.data.model.MovieDetail
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Path

interface MovieRepository {

    suspend fun fetchPopularMovies() : Flow<Resource<List<Movie>>>

    suspend fun fetchMovieDetail(movieId : Int) : Flow<Resource<MovieDetail>>
}