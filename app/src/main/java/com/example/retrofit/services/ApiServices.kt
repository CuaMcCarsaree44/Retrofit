package com.example.retrofit.services
import com.example.retrofit.model.Datas
import retrofit2.Call
import retrofit2.http.GET


//val URL:String = "https://date.nager.at/api/v2/publicholidays/yyyy/CD/"
interface ApiServices {

    @GET("v2/PublicHolidays/")
    fun getAllData(): Call<ArrayList<Datas>>
}