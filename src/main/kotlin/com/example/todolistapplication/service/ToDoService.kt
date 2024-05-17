package com.example.todolistapplication.service

import com.example.todolistapplication.dto.ToDoDTO
import com.example.todolistapplication.entity.ToDoEntity
import com.example.todolistapplication.repository.ToDoRepository
import org.springframework.stereotype.Service

@Service
class Service (
    private val toDoRepository: ToDoRepository
){

    fun findAll():List<ToDoDTO> = toDoRepository.findAll().map { it.toDTO() }
    fun save(toDoDTO: ToDoDTO):ToDoDTO{
        val toDoEntity= ToDoEntity(
            id = toDoDTO.id?:0,
            title =toDoDTO.title,
            description = toDoDTO.description,
            completed =toDoDTO.completed
        )

        return toDoRepository.save(toDoEntity).toDTO()
    }
}


fun ToDoEntity.toDTO():ToDoDTO = ToDoDTO(
    id=this.id,
    title = this.title,
    description = this.description,
    completed = this.completed
)
