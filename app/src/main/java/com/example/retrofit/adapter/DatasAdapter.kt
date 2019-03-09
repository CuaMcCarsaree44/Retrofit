package com.example.retrofit.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofit.R
import com.example.retrofit.model.Datas

class DatasAdapter: RecyclerView.Adapter<DatasAdapter.Handler>() {
    var context: Context? = null
    var collection:ArrayList<Datas>? = null



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Handler {
       var view:View = LayoutInflater.from(context).inflate(R.layout.lists, p0, false)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: Handler, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class Handler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init{

        }
    }
}