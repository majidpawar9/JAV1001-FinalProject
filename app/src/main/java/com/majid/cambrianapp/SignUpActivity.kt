package com.majid.cambrianapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.majid.cambrianapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        // This makes the views defined in activity_main.xml accessible
        // for the UI of this activity
        setContentView(binding.root)
    }
}