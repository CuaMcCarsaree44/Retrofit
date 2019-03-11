package com.example.retrofit.services

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class InitRetrofit {
    companion object {
        var API_KEY:String = "https://date.nager.at/api/v2/PublicHolidays/"
        var EXEC:String = ""
        fun setInit(code:String, year:Int):Retrofit
        {
            EXEC = API_KEY+"$year/$code/"
            return Retrofit.Builder().baseUrl(API_KEY+"$year/$code/").addConverterFactory(GsonConverterFactory.create()).build()
        }

        fun getInstance(code:String, year:Int):ApiServices
        {
            return setInit(code, year).create(ApiServices::class.java)
        }

    }


}