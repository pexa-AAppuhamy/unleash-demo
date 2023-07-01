package com.unleashdemo.backend

import com.unleashdemo.backend.domain.users.Users
import com.unleashdemo.backend.domain.users.UsersRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.UUID

@Configuration
class DataInitialisation(
    private val usersRepository: UsersRepository
) {
    @Bean
    fun addUser() = ApplicationRunner {
        if (usersRepository.findAllUsers().isEmpty()) {
            usersRepository.saveUser(Users(UUID.randomUUID(), "andrew.app@domain.com", "Andrew", "Appuhamy"))
        }
    }
}
