package com.poisonedyouth.taskmanagement.configuration

import com.poisonedyouth.taskmanagement.infrastructure.persistence.TaskRepositoryImpl
import com.poisonedyouth.taskmanagement.repositories.TaskRepository
import com.poisonedyouth.taskmanagement.usecases.CreateTaskUseCase
import com.poisonedyouth.taskmanagement.usecases.GetTasksUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TaskManagementConfiguration {

    @Bean
    fun taskRepository() = TaskRepositoryImpl()

    @Bean
    fun createTaskUseCase(taskRepository: TaskRepository) = CreateTaskUseCase(taskRepository)

    @Bean
    fun getTasksUseCase(taskRepository: TaskRepository) = GetTasksUseCase(taskRepository)
}