package com.example.todolistapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToDoListApplication

fun main(args: Array<String>) {
    runApplication<ToDoListApplication>(*args)
}
