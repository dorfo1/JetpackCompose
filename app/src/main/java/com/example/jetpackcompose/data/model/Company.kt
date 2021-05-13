package com.example.jetpackcompose.data.model

import com.google.gson.annotations.SerializedName

data class Company(
    val id: Int,
    @SerializedName("logo_path")
    val logo: String,
    val name : String
)