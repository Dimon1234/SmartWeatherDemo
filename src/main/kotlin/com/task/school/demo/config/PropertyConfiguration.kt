package com.task.school.demo.config

import org.apache.commons.configuration.PropertiesConfiguration
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File

@Configuration
class PropertyConfiguration {

    @Bean
    @ConditionalOnProperty(name = ["spring.config.location"], matchIfMissing = false)
    @Throws(Exception::class)
    fun propertiesConfiguration(
            @Value("\${spring.config.location}") path: String): PropertiesConfiguration? {
        val filePath: String = File(path.substring("file:".length)).canonicalPath
        val propertiesConfiguration = PropertiesConfiguration(File(filePath))
        propertiesConfiguration.reloadingStrategy = FileChangedReloadingStrategy()
        return propertiesConfiguration
    }
}