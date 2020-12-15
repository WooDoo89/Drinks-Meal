package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DrinksMealSearchFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_layout_drinkmeal_search, container, false)

        var brandy = BrandyData()
        var brandyList = brandy.get()

        var beer = BeerData()
        var beerList = beer.get()

        var test = FoodData()

        test.test?.add(brandyList[0])
        test.test?.add(beerList[0])

//        Thread.sleep(5000)

        Log.d("CHECK!!!!!!!!!!", test.test?.size.toString())

        val mListView = view.findViewById<View>(R.id.listView) as ListView
        val but1: Button = view.findViewById<Button>(R.id.button)
        but1.setOnClickListener {

            val text:TextView = view.findViewById(R.id.name5)
            text.text = "Sorry, but this feature does not work yet"
        }

        return view
    }
}