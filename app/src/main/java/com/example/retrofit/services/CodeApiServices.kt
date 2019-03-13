package com.example.retrofit.services
import com.example.retrofit.model.Roots
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CodeApiServices {
    @GET("{code}")
    fun getAllData(@Path("code") code:String): Call<Roots>
}