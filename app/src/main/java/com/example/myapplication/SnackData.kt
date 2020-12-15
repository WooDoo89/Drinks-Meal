package com.example.myapplication

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class SnackData {
    var Style: String = ""
    var Type: String = ""
    var StyleDescription: String = ""
    var Description: String = ""
    var ABV: Int = 0
    var IBU: Int = 0
    var Color: Int = 0
    fun get(): ArrayList<BeerData>{

        var BD = ArrayList<BeerData>()
        val db = FirebaseFirestore.getInstance()
        val TAG = "CHECK"

        db.collection("Beer")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d(TAG, "${document.id} => ${document.data}")
                        BD.add(document.toObject(BeerData::class.java))
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d(TAG, "Error getting documents: ", exception)
                }
        return BD
    }
}