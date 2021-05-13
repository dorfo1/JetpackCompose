package com.example.jetpackcompose.ui.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.jetpackcompose.R
import com.example.jetpackcompose.core.base.Resource
import com.example.jetpackcompose.data.model.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObserver()
        viewModel.fetchMovies()
    }

    private fun setupObserver() {
        viewModel.movies.observe(this) {
            when (it) {
                is Resource.Success -> println("n de filmes ${it.data?.size}")
                is Resource.Loading -> println("LOADING")
                is Resource.Error -> println("Error")
            }
        }
    }
}

//    TODO APAGAR
fun Context.easyToast(s : String){
    Toast.makeText(this,s,Toast.LENGTH_LONG).show()
}