package com.majid.cambrianapp.ui.apply

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.majid.cambrianapp.R
import com.majid.cambrianapp.databinding.FragmentApplyBinding
import com.majid.cambrianapp.ui.CourseManager
import com.majid.cambrianapp.ui.home.HomeFragment

class ApplyFragment : Fragment(){

    // Adapter and RecyclerView references
    private lateinit var courseAdapter: CourseAdapter
    private lateinit var recyclerView: RecyclerView
    // Binding for the fragment
    private var _binding: FragmentApplyBinding? = null
    private lateinit var checkBox: CheckBox

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("NotifyDataSetChanged", "ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the fragment's layout
        val view = inflater.inflate(R.layout.fragment_apply, container, false)!!
        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        setupRecyclerView(recyclerView)
        // Set up the Apply button
        val applybutton = view.findViewById<Button>(R.id.applyButton)
        applybutton.setOnClickListener {
            // Iterate over RecyclerView to add selected courses
            iterateOverRecyclerView()
            // Navigate to the home screen
            val navController = findNavController()
            navController.navigate(R.id.nav_home)
        }
        return view
    }

    // Set up RecyclerView with sample courses
    private fun setupRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val courses = createSampleCourses() ?: emptyList() // Use empty list if null
        courseAdapter = CourseAdapter(courses)
        recyclerView.adapter = courseAdapter
    }

    // Iterate over RecyclerView to add selected courses to CourseManager
    private fun iterateOverRecyclerView() {

        val courseAdapter = recyclerView.adapter as CourseAdapter

        for (course in courseAdapter.courses) {
            val isChecked = course.isSelected
            if (isChecked){
            CourseManager.addSelectedCourse(course)
            }
        }
    }
    // Create a list of sample courses
    private fun createSampleCourses(): List<Course> {
        return listOf(
            Course("JAV1001", "Introduction to Programming", "Intro to programming concepts.", "Prof. Smith",false),
            Course("WEB1001", "Calculus I", "Fundamental calculus concepts.", "Prof. Johnson",false),
            Course("ISP1002", "Introduction to Programming", "Intro to programming concepts.", "Prof. Smith",false),
            Course("DBA1000", "Introduction to Programming", "Intro to programming concepts.", "Prof. Smith",false),
            Course("BTA1002", "Calculus I", "Fundamental calculus concepts.", "Prof. Johnson",false),
         )
    }
    // Clean up the binding reference when the view is destroyed
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}