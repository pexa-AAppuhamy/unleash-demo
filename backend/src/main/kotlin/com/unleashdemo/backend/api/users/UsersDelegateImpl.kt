package com.unleashdemo.backend.api.users

import com.unleashdemo.backend.common.controller.DefaultDelegate
import com.unleashdemo.backend.common.model.UsersGet200Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class UsersDelegateImpl(
    val usersService: UsersService): DefaultDelegate {
    override fun usersGet(): ResponseEntity<UsersGet200Response> {
        println("Get users")
        return ResponseEntity(UsersGet200Response(usersService.findUsers()), HttpStatus.OK)
    }
}