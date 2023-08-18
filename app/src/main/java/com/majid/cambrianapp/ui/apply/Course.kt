package com.majid.cambrianapp.ui.apply

data class Course(
    val code: String,        // Course code, e.g., "JAV1001"
    val name: String,        // Course name, e.g., "Introduction to Programming"
    val description: String, // Course description
    val professor: String,   // Name of the professor
    var isSelected: Boolean = false // Flag indicating whether the course is selected, defaults to false
)
