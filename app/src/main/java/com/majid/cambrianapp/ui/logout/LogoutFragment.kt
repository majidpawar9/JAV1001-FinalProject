package com.majid.cambrianapp.ui.logout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.majid.cambrianapp.R


class LogoutFragment : Fragment() {


    // This property is only valid between onCreateView and
    // onDestroyView.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Display a toast message indicating successful logout
        Toast.makeText(context, "Successfully Logged Out", Toast.LENGTH_SHORT).show()
        // Inflate the specified layout for the fragment
        return inflater.inflate(R.layout.activity_sign_in, container, true)
    }
}