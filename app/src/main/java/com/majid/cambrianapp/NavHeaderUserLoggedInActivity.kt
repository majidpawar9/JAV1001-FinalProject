package com.majid.cambrianapp

import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth

import com.majid.cambrianapp.databinding.NavHeaderUserLoggedInBinding


class NavHeaderUserLoggedInActivity: BaseActivity() {
    private lateinit var binding: NavHeaderUserLoggedInBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout using data binding
        binding = NavHeaderUserLoggedInBinding.inflate(layoutInflater)
        val user = auth.currentUser

        // Set user information using the binding
        binding.navHeadUserEmail.text = user?.email
        binding.navHeadUserName.text = user?.displayName
    }
}