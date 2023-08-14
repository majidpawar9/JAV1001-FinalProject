package com.majid.cambrianapp.ui.apply

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.majid.cambrianapp.R

class CourseAdapter(val courses: List<Course>) :
    RecyclerView.Adapter<CourseAdapter.ViewHolder>() {
    private val selectedCourses = mutableListOf<Course>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = courses[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int {
        return courses.size
    }
    fun getSelectedCourses(): List<Course> {
        return selectedCourses.toList()
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val courseCodeTextView: TextView = itemView.findViewById(R.id.courseCodeTextView)
        private val courseNameTextView: TextView = itemView.findViewById(R.id.courseNameTextView)
        private val courseDescriptionTextView: TextView = itemView.findViewById(R.id.courseDescriptionTextView)
        private val courseProfessorTextView: TextView = itemView.findViewById(R.id.courseProfessorTextView)
        private val courseCheckBox: CheckBox = itemView.findViewById(R.id.courseCheckBox)

        fun bind(course: Course) {
            courseCodeTextView.text = course.code
            courseNameTextView.text = course.name
            courseDescriptionTextView.text = course.description
            courseProfessorTextView.text = course.professor
            courseCheckBox.isChecked = course.isSelected

            courseCheckBox.setOnCheckedChangeListener { _, isChecked ->
                course.isSelected = isChecked
            }
        }
    }
}
