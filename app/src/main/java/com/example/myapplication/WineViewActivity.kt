package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class WineViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wine_activity_view)

        var wine = WineData()
        var winelist = wine.get()

        //Thread.sleep(5000)

        val mListView = findViewById<View>(R.id.listView) as ListView
        val but1: Button = findViewById<Button>(R.id.button)
        but1.setOnClickListener {
            val beerListAdapter = WineListAdapter(this, winelist)
            mListView.adapter = beerListAdapter
        }
    }
}