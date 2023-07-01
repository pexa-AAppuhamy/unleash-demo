package com.unleashdemo.backend.api.users

import com.unleashdemo.backend.common.controller.DefaultDelegate
import com.unleashdemo.backend.common.model.UserDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class UsersDelegateImpl(
    val usersService: UsersService): DefaultDelegate {
    override fun usersGet(): ResponseEntity<List<UserDto>> {
        println("Get users")
        return ResponseEntity(usersService.findUsers(), HttpStatus.OK)
    }
}