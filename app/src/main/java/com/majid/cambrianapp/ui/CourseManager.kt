package com.majid.cambrianapp.ui

import com.majid.cambrianapp.ui.apply.Course

object CourseManager {
    private val selectedCourses = mutableListOf<Course>()

    fun getSelectedCourses(): List<Course> {
        return selectedCourses.toList()
    }

    fun addSelectedCourse(course: Course) {
        if(selectedCourses.contains(course)) {
            return
        }
        else{
            selectedCourses.add(course)
        }
    }
}