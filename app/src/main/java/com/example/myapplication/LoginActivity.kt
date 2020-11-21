package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        var helping = UserData()
        var allUsers = helping.get()

        val returnToMain: Button = findViewById<Button>(R.id.returnToMain)
        returnToMain.setOnClickListener {
            finish()
        }

        val login: Button = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            val userLogin = findViewById<EditText>(R.id.loginInput)
            val password = findViewById<EditText>(R.id.passwordInput)
            val notification = findViewById<TextView>(R.id.notification)
            var loginUser = UserDB()

            if(userLogin.text.toString() == ""){
                userLogin.error = "Username cannot be empty"
                password.text = null
            }
            if(password.text.toString() == ""){
                password.error = "Password cannot be empty"
                userLogin.text = null
            }
            if(loginUser.checkIfPasswordExists(password.text.toString(), allUsers)){
                password.error = "Password does not match"
                userLogin.text = null
                password.text = null
            }
            if(loginUser.checkIfUsernameExists(userLogin.text.toString(), allUsers)){
                userLogin.error = "Username has not been found"
                userLogin.text = null
                password.text = null
            }
            if(password.text.toString() != "" && userLogin.text.toString() != ""){
                notification.text = "You have been logged in!"
                Thread.sleep(500)
                val i = Intent(applicationContext, MainMenuActivity::class.java)
                startActivity(i)
            }
            else{
                notification.text = "Please correct your data"
            }
        }

    }
}