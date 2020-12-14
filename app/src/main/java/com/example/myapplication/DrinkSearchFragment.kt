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
            val i = Intent(activity?.applicationContext, DrinksViewActivity::class.java)
            startActivity(i)
        }
        val wineBut: Button = view.findViewById(R.id.wineBut)
        wineBut.setOnClickListener {
            val i = Intent(activity?.applicationContext, WineViewActivity::class.java)
            startActivity(i)
        }
        return view
    }
}

