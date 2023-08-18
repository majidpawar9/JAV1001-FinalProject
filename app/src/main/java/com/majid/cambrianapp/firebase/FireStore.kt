package com.majid.cambrianapp.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.majid.cambrianapp.SignInActivity
import com.majid.cambrianapp.SignUpActivity
import com.majid.cambrianapp.User
import com.majid.cambrianapp.utils.Constants

class FireStore {
    // Create an instance of Firebase Firestore
    private var mFireStore= FirebaseFirestore.getInstance()

    // Function to register a user with their information
    fun registerUser(activity: SignUpActivity, userInfo: User){
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                // Callback to indicate successful user registration
                activity.userRegisteredSuccess()
            }
    }

    // Function to get the current user's unique ID from Firebase Authentication
    fun getCurrentUserId(): String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }

    // Function to sign in a user
    fun signInUser(activity: SignInActivity){
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener { document ->
                // Retrieve user data from Firestore document
                val loggedInUser = document.toObject(User::class.java)
                if(loggedInUser !=null){
                    // Callback to indicate successful user sign-in
                    activity.signInSuccess(loggedInUser)
            }
            }
    }
}