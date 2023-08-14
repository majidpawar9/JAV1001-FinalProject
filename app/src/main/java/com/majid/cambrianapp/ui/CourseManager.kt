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
    fun removeUnSelectedCourse(course: Course) {
        if(selectedCourses.contains(course)) {
            selectedCourses.remove(course)
        }
        else{
            return
        }
    }
    fun addList(course: List<Course>){
        selectedCourses.addAll(course)
    }
}