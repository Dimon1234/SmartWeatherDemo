package com.task.school.demo.controller

import mu.KotlinLogging
import com.task.school.demo.model.InfoRequest
import com.task.school.demo.model.InfoResponse
import com.task.school.demo.service.WeatherService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@CrossOrigin
@RestController
class WeatherController(private val weatherService: WeatherService) {
    private val log = KotlinLogging.logger {}

    @PostMapping("/info")
    fun getInfo(@RequestBody infoRequest: InfoRequest?): InfoResponse? {
        try {
            return weatherService.getWeatherInfo(infoRequest)
        } catch (e: RuntimeException) {
            log.error { e }
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "City doesn't exist")
        }
    }
}