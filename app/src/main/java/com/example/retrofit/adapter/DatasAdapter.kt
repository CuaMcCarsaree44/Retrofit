package com.example.retrofit.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.retrofit.R
import com.example.retrofit.model.Datas

class DatasAdapter(var context:Context): RecyclerView.Adapter<DatasAdapter.Handler>() {
    var collection:ArrayList<Datas>? = null

    init{
        this.context = context
    }

    fun setColl(coll:ArrayList<Datas>)
    {
        collection = coll
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Handler {
       var view:View = LayoutInflater.from(context).inflate(R.layout.lists, p0, false)

        var handle:Handler = Handler(view)
        return handle
    }

    override fun getItemCount(): Int {
        return collection?.size!!.toInt()
    }

    override fun onBindViewHolder(handler: Handler, i: Int) {
      handler.code.setText(collection!!.get(i).countryCode)
        handler.type.setText(collection!!.get(i).type)
        handler.date.setText(collection!!.get(i).date)
        handler.local.setText(collection!!.get(i).localName)
        handler.name.setText(collection!!.get(i).name)
    }


    inner class Handler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var type: TextView
        internal var code:TextView
        internal var date:TextView
        internal var local:TextView
        internal var name:TextView

        init{
            type = itemView.findViewById(R.id.typeLabel)
            code = itemView.findViewById(R.id.codeLabel)
            date = itemView.findViewById(R.id.dateLabel)
            local = itemView.findViewById(R.id.localnameLabel)
            name = itemView.findViewById(R.id.nameLabel)

        }
    }
}