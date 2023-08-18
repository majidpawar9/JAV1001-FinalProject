package com.majid.cambrianapp.ui

import com.majid.cambrianapp.ui.apply.Course

object CourseManager {
    private val selectedCourses = mutableListOf<Course>()

    // Get a list of selected courses
    fun getSelectedCourses(): List<Course> {
        return selectedCourses.toList()
    }

    // Add a course to the selectedCourses list
    fun addSelectedCourse(course: Course) {
        if(selectedCourses.contains(course)) {
            return
        }
        else{
            selectedCourses.add(course)
        }
    }

    // Remove a course from the selectedCourses list
    fun removeUnSelectedCourse(course: Course) {
        if(selectedCourses.contains(course)) {
            selectedCourses.remove(course)
        }
        else{
            return
        }
    }
    // Add a list of courses to the selectedCourses list
    fun addList(course: List<Course>){
        selectedCourses.addAll(course)
    }
}