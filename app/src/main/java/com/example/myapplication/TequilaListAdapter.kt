package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TequilaListAdapter(private val context: Context,
                         private val dataSource: ArrayList<TequilaData>) : BaseAdapter() {
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
        val rowView = inflater.inflate(R.layout.rum_adapter_view_layout, parent, false)

        val tvType: TextView = rowView.findViewById(com.example.myapplication.R.id.textView1)
        val tvDescription: TextView = rowView.findViewById(com.example.myapplication.R.id.textView4)
        val tvABV: TextView = rowView.findViewById(com.example.myapplication.R.id.textView5)

        val rum = getItem(position) as TequilaData

        tvType.text = rum.Type
        tvDescription.text = rum.Description
        tvABV.text = rum.ABV.toString() + " %"

        return rowView
    }
}