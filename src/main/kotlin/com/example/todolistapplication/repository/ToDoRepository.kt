package com.example.todolistapplication.repository

import com.example.todolistapplication.entity.ToDoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ToDoRepository:JpaRepository<ToDoEntity,Long> {
}