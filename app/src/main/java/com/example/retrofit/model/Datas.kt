package com.example.retrofit.model

import com.google.gson.annotations.SerializedName

data class Datas(
    @SerializedName("countryCode") var countryCode: String,
    @SerializedName("date") var date: String,
    @SerializedName("localName") var localName: String,
    @SerializedName("name") var name: String,
    @SerializedName("type")var type: String
)