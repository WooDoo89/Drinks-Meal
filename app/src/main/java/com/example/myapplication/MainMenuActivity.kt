package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.ui.main.SectionsPagerAdapter
import com.google.firebase.firestore.FirebaseFirestore
import android.view.View
import android.widget.Button
import android.widget.ListView

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        //while(true){

//            if(beer.setUp()){
//                val mListView = findViewById<View>(R.id.listView) as ListView
//                val beerListAdapter = BeerListAdapter(this, beerList)
//                mListView.adapter = beerListAdapter
//            }

        //}

    }
}