package com.example.myapplication

import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        var helping = UserData()
        var allUsers = helping.get()

        val returnToMain: Button = findViewById<Button>(R.id.returnToMain)
        returnToMain.setOnClickListener {
            finish()
        }

        val register: Button = findViewById<Button>(R.id.register)
        register.setOnClickListener {

            val email = findViewById<EditText>(R.id.emailInput)
            val name = findViewById<EditText>(R.id.nameInput)
            val surname = findViewById<EditText>(R.id.surnameInput)
            val username = findViewById<EditText>(R.id.loginInput)
            val password = findViewById<EditText>(R.id.passwordInput)
            val passwordConfirm = findViewById<EditText>(R.id.passwordInputConfirm)
            val phone = findViewById<EditText>(R.id.phoneInput)
            val check = findViewById<CheckBox>(R.id.checkBox)

            val notification = findViewById<TextView>(R.id.notification)
            var registerUser = UserDB()
            if(!registerUser.checkIfEmailIsValidate(email.text.toString())){
                email.error = "Incorrect Email"
                nullIfFalse(password, passwordConfirm)
                email.text = null
            }
            if(!registerUser.checkIfPasswordIsValidate(password.text.toString(), passwordConfirm.text.toString())){
                password.error = "Passwords does not match"
                passwordConfirm.error = "Passwords does not match"
                nullIfFalse(password, passwordConfirm)
            }
            if(!registerUser.checkIfPhoneIsValidate(phone.text.toString())){
                phone.error = "Incorrect Phone Number"
                nullIfFalse(password, passwordConfirm)
                phone.text = null
            }
            if(password.text.toString() == ""){
                password.error = "Password cannot be empty"
                nullIfFalse(password, passwordConfirm)
            }
            if(passwordConfirm.text.toString() == ""){
                passwordConfirm.error = "Password cannot be empty"
                nullIfFalse(password, passwordConfirm)
            }
            if(name.text.toString() == ""){
                name.error = "Name cannot be empty"
                nullIfFalse(password, passwordConfirm)
                name.text = null
            }
            if(surname.text.toString() == ""){
                surname.error = "Surname cannot be empty"
                nullIfFalse(password, passwordConfirm)
                surname.text = null
            }
            if(username.text.toString() == ""){
                username.error = "Username cannot be empty"
                nullIfFalse(password, passwordConfirm)
                username.text = null
            }
            if(!check.isChecked){
                check.error = "Need to agree"
                nullIfFalse(password, passwordConfirm)
            }
            if (!registerUser.checkIfPhoneExists(phone.text.toString(), allUsers)) {
                phone.error = "This phone is already taken"
                nullIfFalse(password, passwordConfirm)
                phone.text = null
            }
            if (!registerUser.checkIfEmailExists(email.text.toString(), allUsers)) {
                email.error = "This email is already taken"
                nullIfFalse(password, passwordConfirm)
                email.text = null
            }
            if (!registerUser.checkIfUsernameExists(username.text.toString(), allUsers)) {
                username.error = "This Username is already taken"
                nullIfFalse(password, passwordConfirm)
                username.text = null
            }
            if (phone.text.toString() != "" && email.text.toString() != "" && username.text.toString() != ""
                && check.isChecked && username.text.toString() != "" && surname.text.toString() != ""
                && name.text.toString() != "" && password.text.toString() != "" && passwordConfirm.text.toString() != "") {
                registerUser.registration(
                    username.text.toString(),
                    email.text.toString(),
                    phone.text.toString(),
                    name.text.toString(),
                    surname.text.toString(),
                    password.text.toString()
                )
                notification.text = "User has been created! Please login to your account"
                Thread.sleep(1000)
                finish()
            }
            else{
                notification.text = "User has not been created. Please write all data correctly"
            }
        }
    }
    private fun nullIfFalse(password: EditText, passwordConfirm: EditText){
        password.text = null
        passwordConfirm.text = null
    }
}