package com.poisonedyouth.taskmanagement.usecases

import com.poisonedyouth.taskmanagement.model.Task
import com.poisonedyouth.taskmanagement.model.TaskId
import com.poisonedyouth.taskmanagement.model.TaskStatus
import com.poisonedyouth.taskmanagement.repositories.TaskRepository
import java.util.UUID

class CreateTaskUseCase(private val taskRepository: TaskRepository) {
    fun execute(taskData: NewTaskData): Task {
        // Validate task data
        val task = Task(
            id = generateTaskId(),
            title = taskData.title,
            description = taskData.description,
            assignee = null,
            status = TaskStatus.TODO
        )

        // Save the task to the repository
        return taskRepository.create(task)
    }

    private fun generateTaskId(): TaskId {
        return TaskId(
            id = UUID.randomUUID()
        )
    }
}

data class NewTaskData(
    val title: String,
    val description: String
)