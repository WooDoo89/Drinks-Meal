package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore

class ProfileFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_layout_profile, container, false)

        var user = UserData()
        val textView: TextView = view.findViewById(R.id.textViewProfile)

        user = user.getUser(user.getCurrentUser())

        textView.text = user.Username

        val nameView: EditText = view.findViewById(R.id.nameInputOutput)
        nameView.setText(user.Name)

        val surnameView: EditText = view.findViewById(R.id.surnameInputOutput)
        surnameView.setText(user.Surname)

        val editText :EditText = view.findViewById(R.id.nameInputOutput)
        disableEditText(editText)
        return view
    }
    private fun disableEditText(editText: EditText) {
        editText.isFocusable = false;
        editText.isEnabled = false;
        editText.isCursorVisible = false;
        editText.keyListener = null;
        editText.setBackgroundColor(Color.TRANSPARENT);
    }
}