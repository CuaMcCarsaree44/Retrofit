package com.example.retrofit.model

import com.google.gson.annotations.SerializedName

data class datas(
    @SerializedName("Authors")
    val authors: List<Author>,
    @SerializedName("CoverThumb")
    val coverThumb: String,
    @SerializedName("Description")
    val description: String,
    @SerializedName("ISBN")
    val iSBN: String,
    @SerializedName("LanguageCode")
    val languageCode: String,
    @SerializedName("Subjects")
    val subjects: List<String>,
    @SerializedName("Subtitle")
    val subtitle: String,
    @SerializedName("Title")
    val title: String
)