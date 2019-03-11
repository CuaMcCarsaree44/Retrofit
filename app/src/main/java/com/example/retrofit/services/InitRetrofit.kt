package com.example.retrofit.services

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class InitRetrofit {
    companion object {
        var API_KEY:String = "https://date.nager.at/api/v2/PublicHolidays/"
        fun setInit(code:String, year:Int):Retrofit
        {
            API_KEY = API_KEY + "$year/$code/"
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(API_KEY).build()
        }

        fun getInstance(code:String, year:Int):ApiServices
        {
            return setInit(code, year).create(ApiServices::class.java)
        }

    }


}