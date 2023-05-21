package com.poisonedyouth.taskmanagement.interfaces.controller

import com.poisonedyouth.taskmanagement.model.Task
import com.poisonedyouth.taskmanagement.model.TaskStatus
import com.poisonedyouth.taskmanagement.usecases.CreateTaskUseCase
import com.poisonedyouth.taskmanagement.usecases.GetTasksUseCase
import com.poisonedyouth.taskmanagement.usecases.NewTaskData
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskController(
    private val createTaskUseCase: CreateTaskUseCase,
    private val getTasksUseCase: GetTasksUseCase,
) {

    @PostMapping("/task")
    fun createTask(@RequestBody taskData: NewTaskData): ResponseEntity<TaskDto> {
        val createdTask = createTaskUseCase.execute(taskData).toTaskDto()
        return ResponseEntity(createdTask, HttpStatus.CREATED)
    }

    @GetMapping("/task")
    fun getTasks(): ResponseEntity<List<TaskDto>> {
        val existingTasks = getTasksUseCase.queryAll().map { it.toTaskDto() }
        return ResponseEntity(existingTasks, HttpStatus.OK)
    }
}

data class TaskDto(
    val id: String,
    val title: String,
    val description: String,
    val assignee: UserDto?,
    val status: TaskStatus
)

fun Task.toTaskDto() = TaskDto(
    id = this.id.id.toString(),
    title = this.title,
    description = this.description,
    assignee = this.assignee?.toUserDto(),
    status = this.status
)