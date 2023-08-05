package com.majid.cambrianapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.majid.cambrianapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    // enabled binding in a module
    // ActivitySignUpBinding creates a binding class for each XML layout file present in that module.
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        // This makes the views defined in activity_sign_up.xml accessible
        // for the UI of this activity
        setContentView(binding.root)

        // This button will redirect to SignInActivity Layout
        binding.redSignIn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}