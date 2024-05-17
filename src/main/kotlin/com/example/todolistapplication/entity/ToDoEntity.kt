package com.example.todolistapplication.entity

import jakarta.persistence.*

@Entity
@Table(name = "todo_list")
class ToDoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long = 0,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var description: String,

    @Column(nullable = false)
    var completed:Boolean = false
) {

}