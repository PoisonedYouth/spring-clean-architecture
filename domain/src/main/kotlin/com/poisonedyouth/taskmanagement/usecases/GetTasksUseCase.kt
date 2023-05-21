package com.poisonedyouth.taskmanagement.usecases

import com.poisonedyouth.taskmanagement.model.Task
import com.poisonedyouth.taskmanagement.repositories.TaskRepository

class GetTasksUseCase(private val taskRepository: TaskRepository) {
    fun queryAll(): List<Task> {
        return taskRepository.getAll()
    }
}