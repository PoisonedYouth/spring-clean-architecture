package com.poisonedyouth.taskmanagement.usecases

import com.poisonedyouth.taskmanagement.model.TaskStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CreateTaskUseCaseIntegrationTest {

    @Autowired
    private lateinit var createTaskUseCase: CreateTaskUseCase

    @Test
    fun `create task use case is working as expected`() {
        // given
        val title = "My title"
        val description = "My description"

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
    }
}