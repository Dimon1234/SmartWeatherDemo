package com.task.school.demo.controller

import com.task.school.demo.model.InfoRequest
import org.apache.commons.configuration.PropertiesConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ConfigController(private val propertyConfiguration: PropertiesConfiguration) {

    @GetMapping("/configuration/refresh")
    fun getInfo(@RequestBody infoRequest: InfoRequest?): String {
        propertyConfiguration.refresh()
        return "Configuration refreshed successfully"
    }
}