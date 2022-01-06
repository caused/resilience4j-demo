package io.caused.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientFactory {
    @Bean
    fun webClient(@Value("\${producer.url}") url : String): WebClient {
        return WebClient
            .builder().baseUrl(url).build()
    }
}