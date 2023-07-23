package com.majid.cambrianapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.majid.cambrianapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // enabled binding in a module
    // ActivityMainBinding creates a binding class for each XML layout file present in that module.
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // This makes the views defined in activity_main.xml accessible
        // for the UI of this activity
        setContentView(binding.root)

        binding.signUp.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }
    }
}