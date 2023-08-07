package com.majid.cambrianapp

import android.content.Intent
import android.os.Bundle
import com.majid.cambrianapp.databinding.ActivitySignInBinding

class SignInActivity : BaseActivity() {
    // enabled binding in a module
    // ActivitySignInBinding creates a binding class for each XML layout file present in that module.
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)

        // This makes the views defined in activity_sign_in.xml accessible
        // for the UI of this activity
        setContentView(binding.root)

        // This button will redirect to SignUpActivity Layout
        binding.redSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        binding.signInButton.setOnClickListener {
            startActivity(Intent(this, UserLoggedInActivity::class.java))
        }
    }
}