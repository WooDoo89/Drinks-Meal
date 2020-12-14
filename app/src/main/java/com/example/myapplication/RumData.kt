package com.example.myapplication

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class RumData {
    var Type: String = ""
    var Description: String = ""
    var ABV: Int = 0

    fun get(): ArrayList<RumData>{

        var BD = ArrayList<RumData>()
        val db = FirebaseFirestore.getInstance()
        val TAG = "CHECK"

        db.collection("Rum")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    BD.add(document.toObject(RumData::class.java))
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
        return BD
    }
}