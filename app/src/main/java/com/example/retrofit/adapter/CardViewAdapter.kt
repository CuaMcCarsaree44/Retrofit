package com.example.retrofit.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.retrofit.R
import com.example.retrofit.cardDetail
import com.example.retrofit.model.Datas
import org.jetbrains.annotations.NotNull

class CardViewAdapter(var context: Context): RecyclerView.Adapter<CardViewAdapter.Handler>() {
    var collection:ArrayList<Datas> = ArrayList<Datas>()

    init{
        this.context = context
    }

    fun setColl(coll: ArrayList<Datas>?)
    {
        collection = coll!!
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Handler {
        var view: View = LayoutInflater.from(context).inflate(R.layout.listscard , p0, false)

        var handle:Handler = Handler(view)
        return handle
    }

    override fun getItemCount(): Int {
        return collection?.size!!
    }

    override fun onBindViewHolder(handler: Handler, i: Int) {
        handler.id.text = (i+1).toString()
        handler.name.text = collection.get(i).name

        handler.itemView.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                var intent: Intent = Intent(context, cardDetail::class.java)
                intent.putExtra(cardDetail.CODE_PRIMARY_KEY, collection.get(i).countryCode)
                intent.putExtra(cardDetail.DATE_PRIMARY_KEY, collection.get(i).date)
                intent.putExtra(cardDetail.FESTIVAL_PRIMARY_KEY, collection.get(i).name)
                intent.putExtra(cardDetail.LOCAL_PRIMARY_KEY, collection.get(i).localName)
                intent.putExtra(cardDetail.STATUS_PRIMARY_KEY, collection.get(i).type)
                context.startActivity(intent)

            }

        })
    }


    inner class Handler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var name:TextView
        internal var id:TextView

        init{
            name = itemView.findViewById(R.id.cardTitle)
            id = itemView.findViewById(R.id.cardID)
        }
    }
}