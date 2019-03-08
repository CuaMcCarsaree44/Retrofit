package com.example.retrofit

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.retrofit.services.ApiServices
import com.example.retrofit.services.InitRetrofit
import java.net.URL
import android.net.NetworkInfo
import android.content.Context.CONNECTIVITY_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.net.ConnectivityManager



class MainActivity : AppCompatActivity(), View.OnClickListener {
    var search:Button? = null
    var searchBox:EditText? = null

    fun isConnectedToServer(){
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val ni = cm.activeNetworkInfo
        if (ni != null && ni.isConnected) {
            Toast.makeText(this@MainActivity, "Connection Established", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this@MainActivity, "Ga Connect ka :(", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isConnectedToServer()
        search = findViewById(R.id.searchButton)
        searchBox = findViewById(R.id.searchTextbox)

        search?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        var searchString:String?
       when(view?.id)
       {
           R.id.searchButton ->
           {
               searchString = searchBox?.text.toString()

                Toast.makeText(this, "The Search String is $searchString", Toast.LENGTH_LONG).show()
           }
       }
    }
/*
    fun showBook()
    {
        var api:ApiServices?
        api = InitRetrofit.getInstance()
    }
*/
}


