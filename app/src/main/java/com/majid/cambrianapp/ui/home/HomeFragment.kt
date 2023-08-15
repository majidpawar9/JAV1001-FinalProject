package com.majid.cambrianapp.ui.home

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.customview.widget.Openable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
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
    private lateinit var mProgressDialog: Dialog
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
        val removebutton = view.findViewById<Button>(R.id.removeButton)
        removebutton.setOnClickListener {
            iterateOverRecyclerView()
        }
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
    private fun iterateOverRecyclerView() {

        val courseAdapter = recyclerView.adapter as CourseAdapter

        for (course in courseAdapter.courses) {
            val isChecked = course.isSelected
            if (isChecked == false){
                CourseManager.removeUnSelectedCourse(course)
                val navController = findNavController()
                navController.navigate(R.id.nav_home)
            }

        }
    }
    private fun createSampleCourses(): List<Course> {
        return listOf(
            Course("JAV1001", "Android Development", "Intro to Kotlin programming concepts.", "Prof. Graham Gibson",false),
            Course("WEB1001", "Web Development", "Intro to C# programming concepts.", "Prof. Brent Ritchie",false),
            Course("ISP1002", "iOS Development", "Intro to Swift programming concepts.", "Prof. Joshua Most",false),
            Course("DBA1000", "Data Base - SQL", "Intro to SQL programming concepts.", "Prof. Joseph Glover",false),
            Course("BTA1002", "Business Analysis", "Intro to Agile Methodology", "Prof. Imane Richard",false)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}