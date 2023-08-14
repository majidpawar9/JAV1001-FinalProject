package com.majid.cambrianapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.majid.cambrianapp.databinding.ActivitySignInBinding
import com.majid.cambrianapp.firebase.FireStore

class SignInActivity : BaseActivity() {
    // enabled binding in a module
    // ActivitySignInBinding creates a binding class for each XML layout file present in that module.
    private lateinit var binding: ActivitySignInBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)

        // ...
        // Initialize Firebase Auth
        auth = Firebase.auth

        // This makes the views defined in activity_sign_in.xml accessible
        // for the UI of this activity
        setContentView(binding.root)

        // This button will redirect to SignUpActivity Layout
        binding.redSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        binding.signInButton.setOnClickListener {
            signInUser()
        }
    }

    private fun signInUser(){
        val email: String = binding.emailInputUser.text.toString().trim() { it <= ' '}
        val password: String = binding.passwordInputUser.text.toString().trim() { it <= ' '}

        if(validateSignIn(email,password)){
            showProgressDialog(resources.getString(R.string.please_wait))
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    hideProgressDialog()
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Sign In", "createUserWithEmail:success")
                        FireStore().signInUser(this)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Sign In", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication Failed!",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }
    }

    fun signInSuccess(user: User){
        hideProgressDialog()
        startActivity(Intent(this, UserLoggedInActivity::class.java))
        finish()
    }
    private fun validateSignIn(email:String, password:String): Boolean{
        return when {
            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Please Enter Email!")
                false
            }
            TextUtils.isEmpty(password) -> {
                showErrorSnackBar("Please Enter Password!")
                false
            }
            else -> {
                true
            }
        }
    }
}