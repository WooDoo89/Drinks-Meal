package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore

class ProfileFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_layout_profile, container, false)


        var user = UserData()
        var mainUser = user.getCurrentUser()

        val textView: TextView = view.findViewById(R.id.textViewProfile)
        textView.text = mainUser.Name + " " + mainUser.Surname

        val nameView: TextView = view.findViewById(R.id.userName)
        nameView.text = mainUser.Name

        val surnameView: TextView = view.findViewById(R.id.userSurname)
        surnameView.text = mainUser.Surname

        val phoneView: TextView = view.findViewById(R.id.userPhone)
        phoneView.text = mainUser.Phone

        val emailView: TextView = view.findViewById(R.id.userEmail)
        emailView.text = mainUser.Email

//        val updateBut: Button = view.findViewById(R.id.update)
//        updateBut.setOnClickListener {
//            val i = Intent(activity?.applicationContext, WhiskeyViewActivity::class.java)
//            startActivity(i)
//        }
        return view
    }
}