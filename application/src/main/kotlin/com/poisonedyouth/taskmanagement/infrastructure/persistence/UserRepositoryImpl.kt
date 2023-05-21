package com.poisonedyouth.taskmanagement.infrastructure.persistence

import com.poisonedyouth.taskmanagement.model.User
import com.poisonedyouth.taskmanagement.model.UserId
import com.poisonedyouth.taskmanagement.repositories.UserRepository
import java.util.UUID

class UserRepositoryImpl : UserRepository {
    private val users = mutableListOf<UserEntity>()

    override fun getById(userId: UserId): User? {
        return users.find { it.id == userId.id }?.toUser()
    }
    // Other methods for user management
}

data class UserEntity(
    val id: UUID,
    val name: String,
    val email: String
)

fun UserEntity.toUser() = User(
    id = UserId(this.id),
    name = this.name,
    email = this.email
)

fun User.toUserEntity() = UserEntity(
    id = this.id.id,
    name = this.name,
    email = this.email
)