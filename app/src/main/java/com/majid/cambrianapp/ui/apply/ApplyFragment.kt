package com.majid.cambrianapp.ui.apply

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.majid.cambrianapp.R
import com.majid.cambrianapp.databinding.FragmentApplyBinding

class ApplyFragment : Fragment(){


    private var _binding: FragmentApplyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_apply,container, false)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}