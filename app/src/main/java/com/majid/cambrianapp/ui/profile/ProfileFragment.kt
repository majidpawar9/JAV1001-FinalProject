package com.majid.cambrianapp.ui.profile

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import com.majid.cambrianapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {

    private lateinit var profEmailInput : EditText
    private lateinit var profPhoneInput : EditText
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)!!
        val user = FirebaseAuth.getInstance().currentUser
        database = Firebase.database.reference
        profEmailInput = view.findViewById<EditText>(R.id.profEmailInput)!!
        profPhoneInput = view.findViewById<EditText>(R.id.profPhoneInput)!!
        profEmailInput.text = user?.email?.toEditable()
        profPhoneInput.text = user?.phoneNumber?.toEditable()
        profEmailInput.isEnabled = false
        profPhoneInput.isEnabled = false
        val editButton = view.findViewById<ToggleButton>(R.id.editButton)

        editButton?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                profEmailInput.isEnabled = true
                profPhoneInput.isEnabled = true
            }
            else{
                val newEmail = profEmailInput.text
                val newPhone = profPhoneInput.text
                user?.updateEmail(newEmail.toString())
                val credential = PhoneAuthProvider.getCredential(newPhone.toString(),
                    null.toString()
                )
                user?.updatePhoneNumber(credential)
                profEmailInput.isEnabled = false
                profPhoneInput.isEnabled = false
            }
        }
        return view
    }

    private fun String.toEditable(): Editable {
        return Editable.Factory.getInstance().newEditable(this)
    }
}