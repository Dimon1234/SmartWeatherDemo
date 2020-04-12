package com.task.school.demo.config.properties

import com.task.school.demo.model.WeatherInfo
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotNull
import kotlin.properties.Delegates

@ConfigurationProperties(prefix = "service")
@Component
@Validated
class AdviceProperties {
    @NotNull
    lateinit var advices: Map<String, List<Weather>>


    fun getAdvice(weatherInfo: WeatherInfo): String? {
        val speed = weatherInfo.wind.speed
        val temp = weatherInfo.main.temp
        val weather = weatherInfo.weather[0]
        return advices[weather.main]
                ?.filter { it.maxTemp > temp && it.minTemp < temp }
                ?.findLast { it.windSpeedMax > speed && it.windSpeedMin < speed }
                ?.advice
    }

    class Weather {
        var minTemp by Delegates.notNull<Double>()
        var maxTemp by Delegates.notNull<Double>()
        var windSpeedMin by Delegates.notNull<Double>()
        var windSpeedMax by Delegates.notNull<Double>()
        lateinit var advice: String
    }
}