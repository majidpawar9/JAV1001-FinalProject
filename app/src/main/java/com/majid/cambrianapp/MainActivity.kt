package com.majid.cambrianapp

import android.content.Intent
import android.os.Bundle
import com.majid.cambrianapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    // enabled binding in a module
    // ActivityMainBinding creates a binding class for each XML layout file present in that module.
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // This makes the views defined in activity_main.xml accessible
        // for the UI of this activity
        setContentView(binding.root)

        // This button will redirect to SignUpActivity Layout
        binding.signUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        // This button will redirect to SignUpActivity Layout
        binding.signIn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}