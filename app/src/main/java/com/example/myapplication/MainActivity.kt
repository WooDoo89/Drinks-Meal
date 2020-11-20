package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login: Button = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            val i = Intent(applicationContext, LoginActivity::class.java)
            startActivity(i)
        }

        val register: Button = findViewById<Button>(R.id.register)
        register.setOnClickListener {
            val i = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(i)
        }
    }



//        var beerInfo = ArrayList<BeerData>()
//        var wineInfo = ArrayList<WineData>()
//
//        var test = BeerData()
//        beerInfo = test.get()
//        var test2 = WineData()
//        wineInfo = test2.get()
//        Thread.sleep(5000)
//
//
//        val mListView = findViewById<View>(R.id.listView) as ListView
//
//        val but1: Button = findViewById<Button>(R.id.button)
//        but1.setOnClickListener {
//            val beerListAdapter = BeerListAdapter(this, beerInfo)
//            mListView.adapter = beerListAdapter
//        }
//
//        val but2: Button = findViewById<Button>(R.id.button1)
//        but2.setOnClickListener {
//            val wineListAdapter = WineListAdapter(this, wineInfo)
//            mListView.adapter = wineListAdapter
//        }
}