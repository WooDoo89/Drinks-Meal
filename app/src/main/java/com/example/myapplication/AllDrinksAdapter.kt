package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AllDrinksAdapter(private val context: Context,
                       private val dataSource: ArrayList<Any>?) : BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource!!.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource?.get(position)!!
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView2 = inflater.inflate(R.layout.brandy_adapter_view_layout, parent, false)

//        val tvType: TextView = rowView.findViewById(com.example.myapplication.R.id.textView1)
//        val tvDescription: TextView = rowView.findViewById(com.example.myapplication.R.id.textView4)
//        val tvABV: TextView = rowView.findViewById(com.example.myapplication.R.id.textView5)
//        val tvAged: TextView = rowView.findViewById(com.example.myapplication.R.id.textView6)
//
        val test = getItem(position) as Any
        if(test is BrandyData){
            val rowView = inflater.inflate(R.layout.brandy_adapter_view_layout, parent, false)

            val tvType: TextView = rowView.findViewById(com.example.myapplication.R.id.textView1)
            val tvDescription: TextView = rowView.findViewById(com.example.myapplication.R.id.textView4)
            val tvABV: TextView = rowView.findViewById(com.example.myapplication.R.id.textView5)
            val tvAged: TextView = rowView.findViewById(com.example.myapplication.R.id.textView6)

            val brandy = getItem(position) as BrandyData

            tvType.text = brandy.Type
            tvDescription.text = brandy.Description
            tvABV.text = brandy.ABV.toString() + " %"
            tvAged.text = brandy.Aged.toString() + " years"

            return rowView
        }
        if(test is BeerData){
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
            tvABV.text = beer.ABV.toString() + " %"
            tvIBU.text = beer.IBU.toString() + " Bitterness"
            tvColor.text = beer.Color.toString() + " SRM"

            return rowView
        }
        if(test is WineData){
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
        if(test is WhiskeyData){
            val rowView = inflater.inflate(R.layout.whiskey_adapter_view_layout, parent, false)

            val tvType: TextView = rowView.findViewById(com.example.myapplication.R.id.textView1)
            val tvDescription: TextView = rowView.findViewById(com.example.myapplication.R.id.textView4)
            val tvABV: TextView = rowView.findViewById(com.example.myapplication.R.id.textView5)
            val tvAged: TextView = rowView.findViewById(com.example.myapplication.R.id.textView6)
            val tvFlavor: TextView = rowView.findViewById(com.example.myapplication.R.id.textView3)

            val brandy = getItem(position) as WhiskeyData

            tvType.text = brandy.Type
            tvDescription.text = brandy.Description
            tvFlavor.text = brandy.Flavor
            tvABV.text = brandy.ABV.toString() + " %"
            tvAged.text = brandy.Aged.toString() + " years"

            return rowView
        }
        if(test is TequilaData){
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
        if(test is RumData){
            val rowView = inflater.inflate(R.layout.rum_adapter_view_layout, parent, false)

            val tvType: TextView = rowView.findViewById(com.example.myapplication.R.id.textView1)
            val tvDescription: TextView = rowView.findViewById(com.example.myapplication.R.id.textView4)
            val tvABV: TextView = rowView.findViewById(com.example.myapplication.R.id.textView5)

            val rum = getItem(position) as RumData

            tvType.text = rum.Type
            tvDescription.text = rum.Description
            tvABV.text = rum.ABV.toString() + " %"

            return rowView
        }
        return rowView2
    }
}