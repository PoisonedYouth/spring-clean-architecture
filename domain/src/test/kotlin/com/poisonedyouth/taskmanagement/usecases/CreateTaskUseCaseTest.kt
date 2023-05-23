package com.poisonedyouth.taskmanagement.usecases

import com.poisonedyouth.taskmanagement.model.Task
import com.poisonedyouth.taskmanagement.model.TaskStatus
import com.poisonedyouth.taskmanagement.repositories.TaskRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class CreateTaskUseCaseTest {

    private val taskRepository: TaskRepository = mock()
    private val createTaskUseCase = CreateTaskUseCase(taskRepository)

    @Test
    fun `create task use case is working as expected`() {
        // given
        val title = "My title"
        val description = "My description"

        whenever(taskRepository.create(any())).thenAnswer {
            it.getArgument<Task>(0)
        }

        val taskData = NewTaskData(
            title = title,
            description = description
        )

        // when
        val actual = createTaskUseCase.execute(taskData)

        // then
        assertThat(actual.title).isEqualTo(title)
        assertThat(actual.description).isEqualTo(description)
        assertThat(actual.status).isEqualTo(TaskStatus.TODO)
        assertThat(actual.assignee).isNull()
        verify(taskRepository).create(any())
    }
}