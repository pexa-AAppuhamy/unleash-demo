package com.unleashdemo.backend

import io.getunleash.util.UnleashConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}


