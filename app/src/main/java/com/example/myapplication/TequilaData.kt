package com.example.myapplication

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class TequilaData {
    var Type: String = ""
    var Description: String = ""
    var ABV: Int = 0

    fun get(): ArrayList<TequilaData>{

        var BD = ArrayList<TequilaData>()
        val db = FirebaseFirestore.getInstance()
        val TAG = "CHECK"

        db.collection("Tequila")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    BD.add(document.toObject(TequilaData::class.java))
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
        return BD
    }
}