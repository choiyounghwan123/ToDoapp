package com.example.todolistapplication.controller

import com.example.todolistapplication.dto.ToDoDTO
import com.example.todolistapplication.entity.ToDoEntity
import com.example.todolistapplication.service.Service
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val toDoService: Service
) {
    @GetMapping
    fun getAllToDos(): List<ToDoDTO> = toDoService.findAll()

    @PostMapping
    fun createToDo(@RequestBody toDoDTO: ToDoDTO): ResponseEntity<ToDoDTO> {
        println("create")
        val createdToDo = toDoService.save(toDoDTO)
        return ResponseEntity.ok(createdToDo)
    }
}