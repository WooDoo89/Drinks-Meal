package com.example.myapplication

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class BrandyData {
    var Type: String = ""
    var Description: String = ""
    var ABV: Int = 0
    var Aged: Int = 0

    fun get(): ArrayList<BrandyData>{

        var BD = ArrayList<BrandyData>()
        val db = FirebaseFirestore.getInstance()
        val TAG = "CHECK"

        db.collection("Brandy")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    BD.add(document.toObject(BrandyData::class.java))
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
        return BD
    }
}