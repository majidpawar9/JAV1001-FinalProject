package com.majid.cambrianapp.ui.apply

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
        val ApplyViewModel = ViewModelProvider(this).get(ApplyViewModel::class.java)

        _binding = FragmentApplyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textApply
        ApplyViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}