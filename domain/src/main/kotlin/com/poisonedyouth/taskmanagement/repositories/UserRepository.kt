package com.poisonedyouth.taskmanagement.repositories

import com.poisonedyouth.taskmanagement.model.User
import com.poisonedyouth.taskmanagement.model.UserId

interface UserRepository {
    fun getById(userId: UserId): User?
    // Other methods for user management
}