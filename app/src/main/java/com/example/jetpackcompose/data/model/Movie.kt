package com.example.jetpackcompose.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    val adult: Boolean,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val thumbnail: String?,
    val title: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val popularity: Double,
    @SerializedName("vote_average")
    val voteAvarage: Double,
)

data class MovieList(
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)

data class MovieDetail(
    val id: Int,
    @SerializedName("poster_path")
    val thumbFrontUrl: String,
    @SerializedName("backdrop_path")
    val thumBackUrl: String,
    val title: String,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("vote_average")
    val rating: Double,
    val overview: String,
    val release_date: String,
    val budget: Double,
    val revenue: Double,
    @SerializedName("production_companies")
    val companies: List<Company>,
    @SerializedName("runtime")
    val duracao: Int
)