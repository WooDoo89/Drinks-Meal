package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class WineListAdapter(private val context: Context,
                      private val dataSource: ArrayList<WineData>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.wine_adapter_view_layout, parent, false)

        val tvStyle: TextView = rowView.findViewById(com.example.myapplication.R.id.textView1)
        val tvType: TextView = rowView.findViewById(com.example.myapplication.R.id.textView2)
        val tvDescription: TextView = rowView.findViewById(com.example.myapplication.R.id.textView3)
        val tvABV: TextView = rowView.findViewById(com.example.myapplication.R.id.textView4)

        val wine = getItem(position) as WineData

        tvStyle.text = wine.Style
        tvType.text = wine.Type
        tvABV.text = wine.ABV.toString()
        tvDescription.text = wine.Description

        return rowView
    }
}