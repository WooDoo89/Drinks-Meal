package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class DrinkSearchFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_layout_drink_search, container, false)

        val beerBut: Button = view.findViewById(R.id.bearBut)
        beerBut.setOnClickListener {
            val i = Intent(activity?.applicationContext, BearViewActivity::class.java)
            startActivity(i)
        }

        val brandyBut: Button = view.findViewById(R.id.brandyBut)
        brandyBut.setOnClickListener {
            val i = Intent(activity?.applicationContext, BrandyViewActivity::class.java)
            startActivity(i)
        }

        val rumBut: Button = view.findViewById(R.id.rumBut)
        rumBut.setOnClickListener {
            val i = Intent(activity?.applicationContext, RumViewActivity::class.java)
            startActivity(i)
        }

        val tequilaBut: Button = view.findViewById(R.id.tequilaBut)
        tequilaBut.setOnClickListener {
            val i = Intent(activity?.applicationContext, TequilaViewActivity::class.java)
            startActivity(i)
        }

        val whiskeyBut: Button = view.findViewById(R.id.whiskeyBut)
        whiskeyBut.setOnClickListener {
            val i = Intent(activity?.applicationContext, WhiskeyViewActivity::class.java)
            startActivity(i)
        }
        val wineBut: Button = view.findViewById(R.id.wineBut)
        wineBut.setOnClickListener {
            val i = Intent(activity?.applicationContext, WineViewActivity::class.java)
            startActivity(i)
        }
        //This is obly for view so that we do not need all data view
//        val allBut: Button = view.findViewById(R.id.allBut)
//        allBut.setOnClickListener {
//            val i = Intent(activity?.applicationContext, AllDrinksViewActivity::class.java)
//            startActivity(i)
//        }
        return view
    }
}

