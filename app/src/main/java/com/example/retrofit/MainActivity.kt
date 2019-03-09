package com.example.retrofit

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.retrofit.services.ApiServices
import com.example.retrofit.services.InitRetrofit
import java.net.URL
import android.net.NetworkInfo
import android.content.Context.CONNECTIVITY_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.net.ConnectivityManager
import android.widget.*
import java.lang.Exception


class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    var search:Button? = null
    var searchBox:EditText? = null
    var spinner: Spinner?= null
    var code:String = "ID"
    var text:TextView?= null

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
        spinner = findViewById(R.id.countrypicker)

        text = findViewById(R.id.spinner_label)
        var adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        this.spinner?.setAdapter(adapter)
        this.spinner?.setOnItemSelectedListener(this)

        search?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
       var searchString:String = searchBox?.text.toString()
       when(view?.id)
       {
           R.id.searchButton ->
           {
               try {
                   var numb:Int = searchString.toInt()
                   if(numb > 9999 || numb < 0)
                       Toast.makeText(this@MainActivity, "Your input must 0 to 9999!", Toast.LENGTH_LONG).show()
                   else Toast.makeText(this@MainActivity, "Year is: $numb and Country Code is $code", Toast.LENGTH_LONG).show()
               }catch(e: Exception)
               {
                   Toast.makeText(this@MainActivity, "Please input an Integer. . .", Toast.LENGTH_LONG).show()
               }
           }
       }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        parent?.setSelection(-1)
        text?.setText("--")

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        code = parent?.getItemAtPosition(position).toString()
        text?.setText(code)
    }
/*
    fun showBook()
    {
        var api:ApiServices?
        api = InitRetrofit.getInstance()
    }
*/
}


