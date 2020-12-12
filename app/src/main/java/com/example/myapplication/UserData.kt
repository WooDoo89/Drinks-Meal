package com.example.myapplication

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class UserData {
    var Name: String = ""
    var Surname: String = ""
    var Username: String = ""
    var Password: String = ""
    var Email: String = ""
    var Phone: String = ""
    companion object{
        lateinit var currentUser: String
    }

    fun get(): ArrayList<UserData>{

        var BD = ArrayList<UserData>()
        val db = FirebaseFirestore.getInstance()
        val TAG = "CHECK"

        db.collection("User")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    BD.add(document.toObject(UserData::class.java))
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
        return BD
    }
    fun setCurrentUser(user:String){
        currentUser = user
    }
    fun getCurrentUser(): String {
        return currentUser
    }
}