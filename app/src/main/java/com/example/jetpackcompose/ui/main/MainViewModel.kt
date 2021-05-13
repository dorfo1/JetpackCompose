package com.example.jetpackcompose.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.core.base.Resource
import com.example.jetpackcompose.data.model.Movie
import com.example.jetpackcompose.data.model.MovieDetail
import com.example.jetpackcompose.data.repository.MovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movies = MutableLiveData<Resource<List<Movie>>>()
    val movies: LiveData<Resource<List<Movie>>> get() = _movies

    fun fetchMovies() {
        viewModelScope.launch {
            repository.fetchPopularMovies().collect {
                _movies.postValue(it)
            }
        }
    }
}