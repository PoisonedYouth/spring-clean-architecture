package com.poisonedyouth.taskmanagement.infrastructure.persistence

import com.poisonedyouth.taskmanagement.model.Task
import com.poisonedyouth.taskmanagement.model.TaskId
import com.poisonedyouth.taskmanagement.model.TaskStatus
import com.poisonedyouth.taskmanagement.repositories.TaskRepository
import java.util.UUID

class TaskRepositoryImpl : TaskRepository {
    private val tasks = mutableListOf<TaskEntity>()

    override fun create(task: Task): Task {
        tasks.add(task.toTaskEntity())
        return task
    }

    override fun update(task: Task): Task {
        val existingTask = getById(task.id)
        if (existingTask != null) {
            tasks.remove(existingTask.toTaskEntity())
            tasks.add(task.toTaskEntity())
        }
        return task
    }

    override fun getById(taskId: TaskId): Task? {
        return tasks.find { it.id == taskId.id }?.toTask()
    }

    override fun getAll(): List<Task> {
        return tasks.toList().map { it.toTask() }
    }
}

data class TaskEntity(
    val id: UUID,
    val title: String,
    val description: String,
    val assignee: UserEntity?,
    val status: TaskStatus
)

fun TaskEntity.toTask() = Task(
    id = TaskId(this.id),
    title = this.title,
    description = this.description,
    assignee = this.assignee?.toUser(),
    status = this.status
)

fun Task.toTaskEntity() = TaskEntity(
    id = this.id.id,
    title = this.title,
    description = this.description,
    assignee = this.assignee?.toUserEntity(),
    status = this.status
)