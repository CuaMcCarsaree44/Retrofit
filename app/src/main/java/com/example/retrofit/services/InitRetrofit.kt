package com.example.retrofit.services

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class InitRetrofit {
    companion object {
        var API_KEY:String = "https://www.booknomads.com/api/v0/isbn/"
        fun setInit():Retrofit
        {
            return Retrofit.Builder().baseUrl(API_KEY).addConverterFactory(GsonConverterFactory.create()).build()
        }

        fun getInstance():ApiServices
        {
            return setInit().create(ApiServices::class.java)
        }

    }


}