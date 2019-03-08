package com.example.retrofit.model

import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("Name")
    val name: String
)