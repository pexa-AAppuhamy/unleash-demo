package com.unleashdemo.backend

import io.getunleash.DefaultUnleash
import io.getunleash.util.UnleashConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class UnleashConfig {

    @Bean
    fun setUnleashConfig(
        @Value("\${unleash.url}") url: String,
        @Value("\${unleash.apikey}") apiKey: String
    ): UnleashConfig {
        return UnleashConfig.builder().unleashAPI(url).apiKey(apiKey).appName("com.unleashdemo").instanceId("default")
            .fetchTogglesInterval(3).build()
    }

    @Bean
    fun unleash(unleashConfig: UnleashConfig): DefaultUnleash {
        return DefaultUnleash(unleashConfig)
    }

}