package com.poisonedyouth.taskmanagement.repositories

import com.poisonedyouth.taskmanagement.model.Task
import com.poisonedyouth.taskmanagement.model.TaskId

interface TaskRepository {
    fun create(task: Task): Task
    fun update(task: Task): Task
    fun getById(taskId: TaskId): Task?
    fun getAll(): List<Task>
}