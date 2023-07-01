package com.unleashdemo.backend.domain.users

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface IUsersRepository : JpaRepository<Users, UUID> {
    override fun findAll(): List<Users>
}

@Component
class UsersRepository(
    private val usersRepository: IUsersRepository
) {
    fun findAllUsers():List<Users> {
        runCatching {
            return usersRepository.findAll()
        }.onFailure {
            println("Failed to get users")
        }.getOrThrow()

    }

    fun saveUser(user:Users) {
        usersRepository.save(Users(user.id, user.email, user.firstName, user.lastName))
    }


}