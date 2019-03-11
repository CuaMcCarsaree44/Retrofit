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
    var adapter: DatasAdapter?= null

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
        year = intent.getIntExtra(YEAR_PRIMARY_KEY, 0)
        code = intent.getStringExtra(CODE_PRIMARY_KEY)
        showData()
    }

    fun showData()
    {
        var api:ApiServices = InitRetrofit.getInstance(code, year)
        val collection: Call<ArrayList<Datas>> = api.getAllData()

        collection.enqueue(object: Callback<ArrayList<Datas>> {
            override fun onFailure(call: Call<ArrayList<Datas>>, t: Throwable) {
                Toast.makeText(this@ShowData, "Data Not Found", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ArrayList<Datas>>, response: Response<ArrayList<Datas>>) {
            var status:Boolean = response.isSuccessful
                var feed:ArrayList<Datas> = response.body()!!
            if(status == true) {
                adapter = DatasAdapter(this@ShowData)
                //rView?.getAdapter()?.notifyDataSetChanged()
                adapter?.setColl(feed)

                rView?.adapter = adapter
            }else {
            }
            }

        })
    }


}
