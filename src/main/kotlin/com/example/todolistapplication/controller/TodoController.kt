package com.example.todolistapplication.controller

import com.example.todolistapplication.dto.ToDoDTO
import com.example.todolistapplication.entity.ToDoEntity
import com.example.todolistapplication.service.Service
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

    @GetMapping("/{id}")
    fun getToDoById(@PathVariable id: Long): ResponseEntity<ToDoDTO>{
        val toDoDTO = toDoService.findById(id) ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok(toDoDTO)
    }

    @PostMapping
    fun createToDo(@RequestBody toDoDTO: ToDoDTO): ResponseEntity<ToDoDTO> {
        println("create")
        val createdToDo = toDoService.save(toDoDTO)
        return ResponseEntity.ok(createdToDo)
    }

    @PutMapping("/{id}")
    fun updateToDo(@PathVariable id:Long, @RequestBody updateToDoDTO: ToDoDTO):ResponseEntity<ToDoDTO>{
        val existingToDoDTO = toDoService.findById(id) ?: return ResponseEntity.notFound().build()
        val toDoSave = existingToDoDTO.copy(
            title = updateToDoDTO.title,
            description = updateToDoDTO.description,
            completed = updateToDoDTO.completed
        )
        val savedToDoDTO = toDoService.save(toDoSave)
        return ResponseEntity.ok(savedToDoDTO)
    }

    @DeleteMapping("/{id}")
    fun deleteToDoById(@PathVariable id:Long):ResponseEntity<Void>{
        if (toDoService.findById(id) == null){
            return ResponseEntity.notFound().build()
        }

        toDoService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}