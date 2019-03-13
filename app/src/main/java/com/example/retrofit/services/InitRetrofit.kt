package com.example.retrofit.services

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class InitRetrofit {
    companion object {
        var API_KEY:String = "https://date.nager.at/api/v2/PublicHolidays/"
        var API_KEY2:String = "https://restcountries.eu/rest/v2/alpha/"

        fun setInit():Retrofit
        {
            return Retrofit.Builder().baseUrl(API_KEY).addConverterFactory(GsonConverterFactory.create()).build()
        }

        fun setReturn():Retrofit
        {
            return Retrofit.Builder().baseUrl(API_KEY2).addConverterFactory(GsonConverterFactory.create()).build()
        }

        fun setReturnInstance():CodeApiServices
        {
            return setReturn().create(CodeApiServices::class.java)
        }

        fun getInstance():ApiServices
        {
            return setInit().create(ApiServices::class.java)
        }

    }


}