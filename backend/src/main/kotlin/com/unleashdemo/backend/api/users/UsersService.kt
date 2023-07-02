package com.unleashdemo.backend.api.users


import com.unleashdemo.backend.client.Client
import com.unleashdemo.backend.common.model.UserDto
import com.unleashdemo.backend.domain.users.UsersRepository
import io.getunleash.Unleash
import org.springframework.stereotype.Service

@Service
class UsersService(
    private val usersRepository: UsersRepository,
    private val client: Client,
    private val unleash: Unleash
) {
    fun findUsers(): List<UserDto> {

        if (unleash.isEnabled("usersFromDB")) {
            println("Get users from database")
            return usersRepository.findAllUsers().map {
                    user ->
                UserDto(user.id.toString(), user.email, user.firstName, user.lastName)
            }
        }

        println("Get users from external api")
        return client.getUsersFromProvider()
    }
}