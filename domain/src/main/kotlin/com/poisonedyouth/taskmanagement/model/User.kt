package com.poisonedyouth.taskmanagement.model

import java.util.UUID

data class User(
    val id: UserId,
    val name: String,
    val email: String
)

data class UserId(
    val id: UUID
)