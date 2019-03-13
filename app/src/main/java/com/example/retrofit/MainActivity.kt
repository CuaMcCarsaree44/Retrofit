package com.example.retrofit

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.net.ConnectivityManager
import android.widget.*
import java.lang.Exception
import android.content.Intent
import android.graphics.Color
import android.net.Uri


class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {
    var search:Button? = null
    var searchBox:EditText? = null
    var spinner: Spinner?= null
    var code:String = "ID"
    var text:TextView?= null
    //var video:VideoView?= null


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
        //I was dreaming... Creating my app with Video as a background
        //But it comes end when it return "File is not supported"
       /* video = findViewById(R.id.backgroundVideo)
        var uri:Uri = Uri.parse("android.resource://raw/"+R.raw.video1)

        video?.setVideoURI(uri)
        video?.start()
*/
        text = findViewById(R.id.spinner_label)
        var adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        this.spinner?.adapter = adapter
        this.spinner?.onItemSelectedListener = this

        search?.setOnClickListener(this)

        searchBox?.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                searchBox?.setHint("Year 1-9999")
            }

        })
    }

    override fun onClick(view: View?) {
       var searchString:String = searchBox?.text.toString()
       code = spinner?.selectedItem.toString()
       when(view?.id)
       {
           R.id.searchButton ->
           {
               search?.setBackgroundColor(Color.parseColor("#4FFFFFFF"))
               try {
                   var numb:Int = searchString.toInt()
                   if(numb > 9999 || numb < 1)
                       Toast.makeText(this@MainActivity, "Your input must 0 to 9999!", Toast.LENGTH_LONG).show()
                   else {
                       var intents:Intent = Intent(this@MainActivity, ShowData::class.java)
                       intents.putExtra(ShowData.CODE_PRIMARY_KEY, code)
                       intents.putExtra(ShowData.YEAR_PRIMARY_KEY, numb)
                       startActivity(intents)
                   }
               }catch(e: Exception)
               {
                   Toast.makeText(this@MainActivity, "Please input an Integer. . .", Toast.LENGTH_LONG).show()
               }
               search?.setBackgroundColor(Color.parseColor("#FFFFFF"))
               search?.setOnClickListener(null)
               search?.setOnClickListener(this)
           }


       }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        parent?.setSelection(-1)
        text?.text = "--"

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        code = parent?.getItemAtPosition(position).toString()
        text?.text = code
    }
}


