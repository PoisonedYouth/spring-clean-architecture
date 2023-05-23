package com.poisonedyouth.taskmanagement.interfaces.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@SpringBootTest
class TaskControllerIntegrationTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun `create new task is working as expected`() {
        // given
        val requestBody =
            """
            {
                "title": "My title",
                "description": "My description"
            }
            """.trimIndent()

        // when
        val actual = mvc.perform(
            MockMvcRequestBuilders.post(
                "/task"
            ).contentType(MediaType.APPLICATION_JSON)
                .content(
                    requestBody
                )
        )
            .andExpect(status().isCreated)
            .andReturn()

        // then
        assertThat(actual.response.contentAsString)
            .matches("\\{\"id\":\"(.*?)\",\"title\":\"My title\",\"description\":\"My description\",\"assignee\":null,\"status\":\"TODO\"}")
    }
}