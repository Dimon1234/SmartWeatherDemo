package com.task.school.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class RestClientConfiguration {
    @Bean
    fun createRestTemplate(): RestTemplate {
        return RestTemplate()
    }
}