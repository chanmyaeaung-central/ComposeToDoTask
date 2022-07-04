package com.example.composesamplelisting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class AddTaskViewModel : ViewModel() {

    val tasksLiveData = MutableStateFlow<List<Task>>(
        listOf(
            Task("Go Shopping"),
            Task("Medical Appointment")
        )
    )

    fun addTask(task: Task){
        val list = tasksLiveData.value.toMutableList()
        list.add(task)
        tasksLiveData.value = list
    }

    fun deleteTask(task: Task){
        val list = tasksLiveData.value.toMutableList()
        list.remove(task)
        tasksLiveData.value = list
    }

    fun completeTask(task: Task){
        val list = tasksLiveData.value.toMutableList()
        val index = list.indexOf(task)
        list.removeAt(index)
        val completeTask = task.copy(isCompleted = true)
        list.add(index,completeTask)
        tasksLiveData.value = list
    }
}