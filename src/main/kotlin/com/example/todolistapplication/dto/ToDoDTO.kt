package com.example.todolistapplication.dto

data class ToDoDTO(
    val id: Long? = null,
    val title: String,
    val description:String,
    val completed: Boolean
)
