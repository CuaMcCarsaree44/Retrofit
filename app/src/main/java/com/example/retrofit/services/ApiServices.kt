package com.example.retrofit.services

import com.example.retrofit.model.datas
import retrofit2.http.GET
import retrofit2.Call

//val URL:String = "https://www.booknomads.com/api/v0/isbn/9789000035526"
interface ApiServices {

    @GET("https://www.booknomads.com/api/v0/isbn/")
    fun getAllData(text:String):Call<datas>
}