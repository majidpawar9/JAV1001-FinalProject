package com.majid.cambrianapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.majid.cambrianapp.R
import com.majid.cambrianapp.databinding.FragmentHomeBinding
import com.majid.cambrianapp.ui.CourseManager
import com.majid.cambrianapp.ui.apply.Course
import com.majid.cambrianapp.ui.apply.CourseAdapter

class HomeFragment : Fragment() {

    private lateinit var courseAdapter: CourseAdapter
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)!!
        recyclerView = view.findViewById(R.id.recyclerView)
        setupRecyclerView(recyclerView)
        return view
    }
    private fun setupRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val courses = createSampleCourses() ?: emptyList() // Use empty list if null
        courses.forEach { course ->
            if (course.isSelected) {
                // Do something with the selected course
                CourseManager.addSelectedCourse(course)
            }
        }
        courseAdapter = CourseAdapter(CourseManager.getSelectedCourses())
        recyclerView.adapter = courseAdapter
    }
    private fun createSampleCourses(): List<Course> {
        return listOf(
            Course("JAV1001", "Introduction to Programming", "Intro to programming concepts.", "Prof. Smith",false),
            Course("WEB1001", "Calculus I", "Fundamental calculus concepts.", "Prof. Johnson",false),
            Course("ISP1002", "Introduction to Programming", "Intro to programming concepts.", "Prof. Smith",false),
            Course("DBA1000", "Introduction to Programming", "Intro to programming concepts.", "Prof. Smith",false),
            Course("BTA1002", "Calculus I", "Fundamental calculus concepts.", "Prof. Johnson",false)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}