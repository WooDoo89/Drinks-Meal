package com.example.myapplication

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class WineData {
    var Style: String = ""
    var Type: String = ""
    var Description: String = ""
    var ABV: String = ""

    fun get(): ArrayList<WineData>{

        var BD = ArrayList<WineData>()
        val db = FirebaseFirestore.getInstance()
        val TAG = "CHECK"

        db.collection("Wine")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    BD.add(document.toObject(WineData::class.java))
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
        return BD
    }
}