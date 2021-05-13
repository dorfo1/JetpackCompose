package com.example.jetpackcompose.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jetpackcompose.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Chamada dos detalhes do filme
        viewModel.fetchDetail(567189)
    }
}