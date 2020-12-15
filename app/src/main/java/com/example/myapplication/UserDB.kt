package com.example.myapplication

import android.telephony.PhoneNumberUtils
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import java.security.MessageDigest


class UserDB {
    fun checkIfEmailIsValidate(emailInput: String) : Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()
    }
    fun checkIfPasswordIsValidate(passwordInput: String, passwordConfirmInput: String) : Boolean{
        return passwordInput == passwordConfirmInput
    }
    fun checkIfPhoneIsValidate(phoneInput: String) : Boolean{
        return PhoneNumberUtils.isGlobalPhoneNumber(phoneInput)
    }
    fun checkIfUsernameExists(usernameInput: String, allUsers: ArrayList<UserData>) : Boolean {
        for (item in allUsers) {
            if (item.Username == usernameInput)
                return false
        }
        return true
    }
    fun checkIfUsernameExists2(usernameInput: String, allUsers: ArrayList<UserData>) : UserData {
        for (item in allUsers) {
            if (item.Username == usernameInput)
                return item
        }
        return UserData()
    }
    fun checkIfPasswordExists(password: String, allUsers: ArrayList<UserData>) : Boolean{
        for(item in allUsers){
            if(item.Password == hash(password))
                return false
        }
        return true
    }
    fun checkIfEmailExists(emailInput: String, allUsers: ArrayList<UserData>) : Boolean{
        for(item in allUsers){
            if(item.Email == emailInput)
                return false
        }
        return true
    }
    fun checkIfPhoneExists(phoneInput: String, allUsers: ArrayList<UserData>) : Boolean{
        for(item in allUsers){
            if(item.Phone == phoneInput)
                return false
        }
        return true
    }
    fun registration(usernameInput: String, emailInput: String, phoneInput: String, nameInput: String, surnameInput: String, passwordInput: String) {
        val db = FirebaseFirestore.getInstance()
        val tag = "User Adding"
        val user: MutableMap<String, Any> = HashMap()
        user["Name"] = nameInput
        user["Surname"] = surnameInput
        user["Username"] = usernameInput
        user["Email"] = emailInput
        user["Phone"] = phoneInput
        user["Password"] = hash(passwordInput)
        db.collection("User")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    tag,
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
            }
            .addOnFailureListener { e -> Log.w(tag, "Error adding document", e) }
    }
    fun hash(passwordInput: String): String {
        val bytes = passwordInput.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }
}