package com.majid.cambrianapp.ui.apply

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.majid.cambrianapp.R
import com.majid.cambrianapp.databinding.FragmentApplyBinding

class ApplyFragment : Fragment(){

    private lateinit var courseAdapter: CourseAdapter
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentApplyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_apply, container, false)!!
        recyclerView = view.findViewById(R.id.recyclerView)
        setupRecyclerView(recyclerView)
        return view
    }

    private fun setupRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val courses = createSampleCourses() ?: emptyList() // Use empty list if null
        courseAdapter = CourseAdapter(courses)
        recyclerView.adapter = courseAdapter
    }
    private fun createSampleCourses(): List<Course> {
        return listOf(
            Course("CSE101", "Introduction to Programming", "Intro to programming concepts.", "Prof. Smith"),
            Course("MAT201", "Calculus I", "Fundamental calculus concepts.", "Prof. Johnson"),
            Course("CSE101", "Introduction to Programming", "Intro to programming concepts.", "Prof. Smith"),
            Course("CSE101", "Introduction to Programming", "Intro to programming concepts.", "Prof. Smith"),
            Course("MAT201", "Calculus I", "Fundamental calculus concepts.", "Prof. Johnson"),
            Course("CSE101", "Introduction to Programming", "Intro to programming concepts.", "Prof. Smith"),
            Course("CSE101", "Introduction to Programming", "Intro to programming concepts.", "Prof. Smith"),
            Course("MAT201", "Calculus I", "Fundamental calculus concepts.", "Prof. Johnson"),
            Course("CSE101", "Introduction to Programming", "Intro to programming concepts.", "Prof. Smith"),

            )
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}