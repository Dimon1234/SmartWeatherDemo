package com.task.school.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmartWeatherApplication

fun main(args: Array<String>) {
	runApplication<SmartWeatherApplication>(*args)
}
