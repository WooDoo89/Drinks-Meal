package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView

class WhiskeyViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whiskey_view)

        var beer = WhiskeyData()
        var beerList = beer.get()

        //Thread.sleep(5000)

        val mListView = findViewById<View>(R.id.listView) as ListView
        val but1: Button = findViewById<Button>(R.id.button)
        but1.setOnClickListener {
            val beerListAdapter = WhiskeyListAdapter(this, beerList)
            mListView.adapter = beerListAdapter
        }
    }
}