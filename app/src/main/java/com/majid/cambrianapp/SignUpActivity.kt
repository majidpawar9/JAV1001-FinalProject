package com.majid.cambrianapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.majid.cambrianapp.databinding.ActivitySignUpBinding
import com.majid.cambrianapp.firebase.FireStore

class SignUpActivity : BaseActivity() {
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
        binding.signUpButton.setOnClickListener {
            registerUser()
        }
    }

    //function to register User
    private fun registerUser(){
        val firstName: String = binding.firstNameInput.text.toString().trim { it <= ' '}
        val lastName: String = binding.lastNameInput.text.toString().trim { it <= ' '}
        val email: String = binding.emailInput.text.toString().trim { it <= ' '}
        val phone: String = binding.phoneInput.text.toString().trim { it <= ' '}
        val password: String = binding.passwordInput.text.toString().trim { it <= ' '}

        // validate form will validate every text field
        if (validateForm(firstName,lastName,email,phone,password)){
            showProgressDialog(resources.getString(R.string.please_wait))
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    hideProgressDialog()
                    if (task.isSuccessful) {
                        //creating a new user in Firebase
                        val firebaseUser: FirebaseUser = task.result!!.user!!
                        val registeredEmail = firebaseUser.email!!
                        val user = User(firebaseUser.uid, name = firstName,registeredEmail, phone = phone)
                        FireStore().registerUser(this,user)
                        Toast.makeText(
                            this,
                            "You have Registered successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        FirebaseAuth.getInstance().signOut()
                    } else {
                        Toast.makeText(this, "Registration Failed!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    //to indicate and log user successfully registered
    fun userRegisteredSuccess(){
        Toast.makeText(
            this,
            "You have logged In successfully",
            Toast.LENGTH_SHORT
        ).show()
        hideProgressDialog()
        FirebaseAuth.getInstance().signOut()
        finish()
    }

    //validation form which will validate all EditText inputs
    private fun validateForm(firstName: String, lastName:String, email:String, phoneNumber: String, password:String): Boolean{
        return when {
            TextUtils.isEmpty(firstName) -> {
                showErrorSnackBar("Please Enter First Name!")
                false
            }
            TextUtils.isEmpty(lastName) -> {
                showErrorSnackBar("Please Enter Last Name!")
                false
            }
            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Please Enter Email!")
                false
            }
            TextUtils.isEmpty(phoneNumber) -> {
                showErrorSnackBar("Please Enter Phone Number!")
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