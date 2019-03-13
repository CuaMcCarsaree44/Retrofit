package com.example.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.retrofit.adapter.CardViewAdapter
import com.example.retrofit.adapter.DatasAdapter
import com.example.retrofit.model.Datas
import com.example.retrofit.services.ApiServices
import com.example.retrofit.services.InitRetrofit
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.zip.Inflater

class ShowData : AppCompatActivity() {
    var adapter: DatasAdapter = DatasAdapter(this)
    var cardAdapter:CardViewAdapter = CardViewAdapter(this)

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
        cardView()
    }

    fun cardView()
    {
        rView?.adapter = cardAdapter
        Toast.makeText(this@ShowData, "Card View Implemented", Toast.LENGTH_LONG).show()
        var api:ApiServices = InitRetrofit.getInstance()
        val collection: Call<ArrayList<Datas>> = api.getAllData(year, code)

        collection.enqueue(object: Callback<ArrayList<Datas>> {
            override fun onFailure(call: Call<ArrayList<Datas>>, t: Throwable) {
                Toast.makeText(this@ShowData, "Data Not Found", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ArrayList<Datas>>, response: Response<ArrayList<Datas>>) {
                var status:Boolean = response.isSuccessful
                var feed:ArrayList<Datas>? = response?.body()
                if(status == true) {
                    cardAdapter?.setColl(feed)
                    rView?.adapter?.notifyDataSetChanged()
                }else {
                    Toast.makeText(this@ShowData, "HTTP Status: ${response.code()}", Toast.LENGTH_LONG).show()
                }
            }

        })
    }

    fun showData()
    {
        rView?.adapter = adapter
        var api:ApiServices = InitRetrofit.getInstance()
        val collection: Call<ArrayList<Datas>> = api.getAllData(year, code)
        Toast.makeText(this@ShowData, "List View Implemented", Toast.LENGTH_LONG).show()
        collection.enqueue(object: Callback<ArrayList<Datas>> {
            override fun onFailure(call: Call<ArrayList<Datas>>, t: Throwable) {
                Toast.makeText(this@ShowData, "Data Not Found", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ArrayList<Datas>>, response: Response<ArrayList<Datas>>) {
            var status:Boolean = response.isSuccessful
                var feed:ArrayList<Datas>? = response?.body()
            if(status == true) {
                adapter?.setColl(feed)
                rView?.adapter?.notifyDataSetChanged()
            }else {
                Toast.makeText(this@ShowData, "HTTP Status: ${response.code()}", Toast.LENGTH_LONG).show()
            }
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menus: MenuInflater = getMenuInflater()
        menus.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId)
        {
            R.id.homeOption -> this.finish()
            R.id.cardViewOption -> cardView()
            R.id.listViewOption -> showData()
        }

        return super.onOptionsItemSelected(item)
    }
}
