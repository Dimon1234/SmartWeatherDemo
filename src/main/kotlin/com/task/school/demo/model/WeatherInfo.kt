package com.task.school.demo.model

data class WeatherInfo(val weather: Array<Weather>,
                       val main: Main,
                       val wind: Wind)


data class Weather(val main: String,
                   val description: String)

data class Main(val temp: Double)

data class Wind(val speed: Double)