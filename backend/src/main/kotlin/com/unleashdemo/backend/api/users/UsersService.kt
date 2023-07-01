package com.unleashdemo.backend.api.users

import com.unleashdemo.backend.common.model.UserDto
import com.unleashdemo.backend.domain.users.UsersRepository
import org.springframework.stereotype.Service

@Service
class UsersService(
    private val usersRepository: UsersRepository
) {
    fun findUsers(): List<UserDto> {
        val users = usersRepository.findAllUsers().map {
            user ->
            UserDto(user.id, user.email, user.firstName, user.lastName)
        }
        return users
    }
}