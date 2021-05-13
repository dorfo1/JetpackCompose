package com.example.jetpackcompose.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.core.base.Resource
import com.example.jetpackcompose.data.model.MovieDetail
import com.example.jetpackcompose.data.repository.MovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movieDetail = MutableLiveData<Resource<MovieDetail>>()
    val movieDetail: LiveData<Resource<MovieDetail>> get() = _movieDetail

    fun fetchDetail(int: Int){
        viewModelScope.launch {
            repository.fetchMovieDetail(int).collect {
                _movieDetail.postValue(it)
            }
        }
    }
}