package com.poisonedyouth.taskmanagement.model

import java.util.UUID

data class Task(
    val id: TaskId,
    val title: String,
    val description: String,
    val assignee: User?,
    val status: TaskStatus
)

enum class TaskStatus {
    TODO, IN_PROGRESS, DONE
}

data class TaskId(
    val id: UUID
)