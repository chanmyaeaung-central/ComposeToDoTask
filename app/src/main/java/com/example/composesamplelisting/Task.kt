package com.example.composesamplelisting

import java.util.*

data class Task(
    val title: String,
    val description: String = "",
    val createdAt: Date = Date(),
    var isCompleted:Boolean = false
)