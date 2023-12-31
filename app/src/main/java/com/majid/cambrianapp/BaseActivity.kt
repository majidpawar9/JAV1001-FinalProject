package com.majid.cambrianapp

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

open class BaseActivity : AppCompatActivity() {
    // Properties
    private lateinit var mProgressDialog: Dialog

    // Override the onCreate method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
    // Show a progress dialog
    fun showProgressDialog(text: String){
        mProgressDialog = Dialog(this)

        mProgressDialog.setContentView(R.layout.dialog_progress)
        mProgressDialog.show()
    }

    // Hide the progress dialog
    fun hideProgressDialog(){
        mProgressDialog.dismiss()
    }

    // Get the current user's ID
    fun getCurrentUserID(): String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }

//    fun doubleBackToExit(){
//        if(doublePressedToExitPressedOnce){
//            super.onBackPressed()
//            return
//        }
//        this.doublePressedToExitPressedOnce = true
//        Toast.makeText(
//            this, resources.getString(R.string.please_click_back_again_to_exit),
//            Toast.LENGTH_SHORT
//        ).show()
//    }

    // Show an error Snackbar
    fun showErrorSnackBar(message: String){
        val snackBar = Snackbar.make(findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(ContextCompat.getColor(this, androidx.constraintlayout.widget.R.color.error_color_material_light))
        snackBar.show()
    }

}