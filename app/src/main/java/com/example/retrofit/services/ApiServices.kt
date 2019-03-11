package com.example.retrofit.services
import com.example.retrofit.model.Datas
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


//val URL:String = "https://date.nager.at/api/v2/publicholidays/yyyy/CD/"
interface ApiServices {

    @GET("{year}/{code}/")
    fun getAllData(@Path("year") year:Int,
                   @Path("code") code:String): Call<ArrayList<Datas>>
}