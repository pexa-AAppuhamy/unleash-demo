package com.unleashdemo.backend.client

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.unleashdemo.backend.common.model.UserDto
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class Client() {
    private val httpClient = OkHttpClient()
    private val jacksonMapper = jacksonObjectMapper()
    private val apiUrl = System.getenv("API_URL")
    fun getUsersFromProvider(): List<UserDto> {
        jacksonMapper.registerKotlinModule()
        val request = Request.Builder()
            .url("http://${apiUrl}:8082/external/users")
            .build()

        val userResponse = httpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            response.body!!.string()
        }

        return jacksonMapper.readValue<UserResponseEntity>(userResponse).users
    }
}

data class UserResponseEntity(val users: List<UserDto>)
