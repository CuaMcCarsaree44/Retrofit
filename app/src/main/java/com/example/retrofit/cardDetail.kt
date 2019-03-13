package com.example.retrofit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.example.retrofit.model.Roots
import com.example.retrofit.services.CodeApiServices
import com.example.retrofit.services.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class cardDetail : AppCompatActivity() {
    companion object {
        val CODE_PRIMARY_KEY:String = "Code"
        val FESTIVAL_PRIMARY_KEY:String = "Festival"
        val LOCAL_PRIMARY_KEY:String = "Local"
        val DATE_PRIMARY_KEY:String = "Dates"
        val STATUS_PRIMARY_KEY:String = "Status"
    }

    var code:String = "FR"

    var country: TextView?= null
    var festival:TextView?= null
    var localName:TextView?= null
    var dates:TextView?= null
    var status:TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        festival = findViewById(R.id.nameLabelCard)
        localName = findViewById(R.id.localLabelCard)
        dates = findViewById(R.id.dateLabelCard)
        status = findViewById(R.id.statusLabelCard)
        country = findViewById(R.id.countryLabelCard)


        var intent:Intent = getIntent()

        code = intent.getStringExtra(CODE_PRIMARY_KEY)
        festival?.text = intent.getStringExtra(FESTIVAL_PRIMARY_KEY)
        localName?.text = intent.getStringExtra(LOCAL_PRIMARY_KEY)
        dates?.text = intent.getStringExtra(DATE_PRIMARY_KEY)
        status?.text = intent.getStringExtra(STATUS_PRIMARY_KEY)


        var api: CodeApiServices = InitRetrofit.setReturnInstance()
        val collection: Call<Roots> = api.getAllData(code)

        collection.enqueue(object: Callback<Roots> {
            override fun onFailure(call: Call<Roots>, t: Throwable) {
                Toast.makeText(this@cardDetail, "${t.message}", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Roots>, response: Response<Roots>) {
                var status: Boolean = response.isSuccessful
                var feed:String? = response.body()!!.name
                if (status == true) {
                    country?.text = feed
                } else {
                    Toast.makeText(this@cardDetail, "HTTP Status: ${response.code()}", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menus: MenuInflater = getMenuInflater()
        menus.inflate(R.menu.card_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId)
        {
            R.id.backButton -> this.finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
