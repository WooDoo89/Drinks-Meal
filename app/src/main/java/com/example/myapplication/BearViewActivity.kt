package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class BearViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks_view)

        var beer = BeerData()
        var beerList = beer.get()

        //Thread.sleep(5000)

        val mListView = findViewById<View>(R.id.listView) as ListView
        val but1: Button = findViewById<Button>(R.id.button)
        but1.setOnClickListener {
            val beerListAdapter = BeerListAdapter(this, beerList)
            mListView.adapter = beerListAdapter
        }

//        val foodTypes = arrayOf("All", "Hot Dish", "Snack", "Desert")
//
//        val foodMainAll = arrayOf("All", "Milk", "Potato", "Beef", "Fish")
//        val foodMainHotDish = arrayOf("All", "Beef", "Snack", "Desert")
//        val foodMainSnack = arrayOf("All", "Potato", "Snack", "Desert")
//        val foodMainDesert = arrayOf("All", "Milk", "Snack", "Desert")
//
//        val foodMainAllName = arrayOf("All", "Hot Dish", "Snack", "Desert")
//        val foodMainHotDishName = arrayOf("All", "Hot Dish", "Snack", "Desert")
//        val foodMainSnackName = arrayOf("All", "Hot Dish", "Snack", "Desert")
//        val foodMainDesertName = arrayOf("All", "Hot Dish", "Snack", "Desert")
//
//        val ArrayAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, foodTypes)
//
//        val spinner:Spinner = findViewById(R.id.spinnerType)
//
//        spinner.adapter = ArrayAdapter
//
//        spinner.onItemSelectedListener = object:
//                AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                val spinner:Spinner = findViewById(R.id.spinnerType)
//
//                spinner.adapter = ArrayAdapter
//            }
//        }
    }
}