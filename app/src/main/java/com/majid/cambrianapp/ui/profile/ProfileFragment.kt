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

    // UI elements
    private lateinit var profEmailInput : EditText
    private lateinit var profPhoneInput : EditText
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the fragment's layout
        val view = inflater.inflate(R.layout.fragment_profile, container, false)!!
        // Get current user and Firebase database reference
        val user = FirebaseAuth.getInstance().currentUser
        database = Firebase.database.reference
        // Initialize UI elements
        profEmailInput = view.findViewById<EditText>(R.id.profEmailInput)!!
        profPhoneInput = view.findViewById<EditText>(R.id.profPhoneInput)!!
        // Disable input fields by default
        profEmailInput.isEnabled = false
        profPhoneInput.isEnabled = false

        // ToggleButton to enable/disable edit mode
        val editButton = view.findViewById<ToggleButton>(R.id.editButton)
        editButton?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                profEmailInput.isEnabled = true
                profPhoneInput.isEnabled = true
            }
            else{
                // Update user's email and phone information
                val newEmail = profEmailInput.text
                val newPhone = profPhoneInput.text
                if (newEmail.toString() == ""){
                    Toast.makeText(requireContext(), "Email cannot be null", Toast.LENGTH_SHORT).show()
                }
                else {
                    // Populate input fields with user's current email
                    user?.updateEmail(newEmail.toString())
                }

                val credential = PhoneAuthProvider.getCredential(newPhone.toString(),
                    null.toString()
                )
                if(credential.toString() == ""){
                    profPhoneInput.text = "".toEditable()
                }
                else {
                    // Populate input fields with user's current phone
                    user?.updatePhoneNumber(credential)
                }
                profEmailInput.isEnabled = false
                profPhoneInput.isEnabled = false
            }
        }
        profEmailInput.text = user?.email?.toEditable()
        profPhoneInput.text = user?.phoneNumber?.toEditable()
        return view
    }

    // Extension function to convert String to Editable
    private fun String.toEditable(): Editable {
        return Editable.Factory.getInstance().newEditable(this)
    }
}