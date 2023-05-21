package com.poisonedyouth.taskmanagement.interfaces.controller

import com.poisonedyouth.taskmanagement.model.User

class UserController {
}

data class UserDto(
    val id: String,
    val name: String,
    val email: String
)

fun User.toUserDto() = UserDto(
    id = this.id.id.toString(),
    name = this.name,
    email = this.email
)