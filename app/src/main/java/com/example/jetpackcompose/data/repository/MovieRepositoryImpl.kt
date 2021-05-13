package com.example.jetpackcompose.data.repository

import com.example.jetpackcompose.core.base.Resource
import com.example.jetpackcompose.core.extension.toFlowResource
import com.example.jetpackcompose.data.model.Movie
import com.example.jetpackcompose.data.model.MovieDetail
import com.example.jetpackcompose.data.service.MovieService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MovieRepositoryImpl(
    private val service: MovieService
) : MovieRepository {

    override suspend fun fetchPopularMovies(): Flow<Resource<List<Movie>>> = flow{
        emit(service.fetchPopularMovies().movies)
    }.toFlowResource()

    override suspend fun fetchMovieDetail(movieId: Int): Flow<Resource<MovieDetail>> = flow {
        emit(service.fetchMovieDetails(movieId))
    }.toFlowResource()
}