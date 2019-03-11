package com.example.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.retrofit.adapter.DatasAdapter
import com.example.retrofit.model.Datas
import com.example.retrofit.services.ApiServices
import com.example.retrofit.services.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowData : AppCompatActivity() {
    var collections: ArrayList<Datas>?=null
    var dataBinder: Datas?=null

    companion object {
        val YEAR_PRIMARY_KEY:String = "Year"
        val CODE_PRIMARY_KEY:String = "Code"
    }


    var year:Int = 0
    var code:String = ""

    var rView:RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)

        rView = findViewById(R.id.recycleview)
        rView!!.layoutManager = LinearLayoutManager(this)
        year = getIntent().getIntExtra(YEAR_PRIMARY_KEY, 0)
        code = getIntent().getStringExtra(CODE_PRIMARY_KEY)
        showData()
    }

    fun showData()
    {
        var api:ApiServices = InitRetrofit.getInstance(code, year)
        val collection:Call<Datas> = api.getAllData()

        collection.enqueue(object: Callback<Datas> {
            override fun onResponse(call: Call<Datas>, response: Response<Datas>) {
               // var coll:ArrayList<Datas> = response.body().
                    dataBinder!!.name = response.body()!!.name
                    dataBinder!!.localName = response.body()!!.localName
                    dataBinder!!.date = response.body()!!.date
                    dataBinder!!.countryCode = response.body()!!.countryCode
                    dataBinder!!.type = response.body()!!.type
                collections?.add(dataBinder!!)
                val adapter:DatasAdapter = DatasAdapter(this@ShowData)
                adapter.setColl(collections!!)
                rView?.setAdapter(adapter)
            }

            override fun onFailure(call: Call<Datas>, t: Throwable) {
                Toast.makeText(this@ShowData, "Data Not Found", Toast.LENGTH_SHORT).show()
            }
        })
    }


}
