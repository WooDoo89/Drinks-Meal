package com.example.myapplication

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class WhiskeyData {
    var Type: String = ""
    var Description: String = ""
    var Flavor: String = ""
    var ABV: Int = 0
    var Aged: Int = 0

    fun get(): ArrayList<WhiskeyData>{

        var BD = ArrayList<WhiskeyData>()
        val db = FirebaseFirestore.getInstance()
        val TAG = "CHECK"

        db.collection("Whiskey")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    BD.add(document.toObject(WhiskeyData::class.java))
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
        return BD
    }
}