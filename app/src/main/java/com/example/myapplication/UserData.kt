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
        lateinit var currentUser: UserData
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
    fun updateUser(){
        
    }
    fun getUser(username: String): UserData{
        val BD = UserData()
        val db = FirebaseFirestore.getInstance()
        val TAG = "-------------------------------------------------------"
        db.collection("User")
                .whereEqualTo("Username", username)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        Log.d(TAG, "${document.id} => ${document.data}")
                        BD.Name = document.toObject(UserData::class.java).Name
                        BD.Surname = document.toObject(UserData::class.java).Surname
                        BD.Phone = document.toObject(UserData::class.java).Phone
                        BD.Email = document.toObject(UserData::class.java).Email
                        BD.Password = document.toObject(UserData::class.java).Password
                        BD.Username = document.toObject(UserData::class.java).Username
                        break;
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents: ", exception)
                }
        return BD
    }
    fun setCurrentUser(user:UserData){
        currentUser = user
    }
    fun getCurrentUser(): UserData {
        return currentUser
    }
}
