package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BeerListAdapter(private val context: Context,
                      private val dataSource: ArrayList<BeerData>) : BaseAdapter() {
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
        val rowView = inflater.inflate(R.layout.beer_adapter_view_layout, parent, false)

        val tvStyle: TextView = rowView.findViewById(com.example.myapplication.R.id.textView1)
        val tvType: TextView = rowView.findViewById(com.example.myapplication.R.id.textView2)
        val tvStyleDescription: TextView = rowView.findViewById(com.example.myapplication.R.id.textView3)
        val tvDescription: TextView = rowView.findViewById(com.example.myapplication.R.id.textView4)
        val tvABV: TextView = rowView.findViewById(com.example.myapplication.R.id.textView5)
        val tvIBU: TextView = rowView.findViewById(com.example.myapplication.R.id.textView6)
        val tvColor: TextView = rowView.findViewById(com.example.myapplication.R.id.textView7)

        val beer = getItem(position) as BeerData

        tvStyle.text = beer.Style
        tvType.text = beer.Type
        tvStyleDescription.text = beer.StyleDescription
        tvDescription.text = beer.Description
        tvABV.text = beer.ABV.toString()
        tvIBU.text = beer.IBU.toString()
        tvColor.text = beer.Color.toString()

        return rowView
    }
}