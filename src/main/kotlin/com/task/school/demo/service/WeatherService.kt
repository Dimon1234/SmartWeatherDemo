package com.task.school.demo.service

import com.task.school.demo.config.properties.AdviceProperties
import com.task.school.demo.model.InfoRequest
import com.task.school.demo.model.InfoResponse
import com.task.school.demo.model.WeatherInfo
import mu.KotlinLogging
import org.apache.commons.configuration.PropertiesConfiguration
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
class WeatherService(private val restTemplate: RestTemplate,
                     private val adviceProperties: AdviceProperties,
                     private val propertyConfiguration: PropertiesConfiguration) {
    private val log = KotlinLogging.logger {}

    fun getWeatherInfo(infoRequest: InfoRequest?): InfoResponse {
        if (infoRequest?.city.isNullOrBlank()) throw NullPointerException("City is null")
        val uriBuilder = UriComponentsBuilder.fromHttpUrl(propertyConfiguration.getProperty("weather-api").toString())
                .queryParam("q", "${infoRequest?.city}, ${infoRequest?.country}, ${infoRequest?.state}")
                .queryParam("appid", propertyConfiguration.getProperty("authToken").toString())

        val weatherInfo = requestWeather(uriBuilder)
        val infoResponse = InfoResponse(weatherInfo!!.weather[0].main, weatherInfo.weather[0].description, adviceProperties.getAdvice(weatherInfo))
        log.info { "service response for city ${infoRequest?.city} is $infoResponse" }

        return infoResponse
    }

    private fun requestWeather(uriBuilder: UriComponentsBuilder): WeatherInfo? {
        return try {
            restTemplate.getForObject(uriBuilder.toUriString(), WeatherInfo::class.java)
        } catch (e: RuntimeException) {
            log.warn { "api request failed with exception $e" }
            null
        }
    }
}