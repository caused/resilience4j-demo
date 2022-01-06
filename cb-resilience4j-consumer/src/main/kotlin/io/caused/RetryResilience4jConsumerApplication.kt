package io.caused

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient

@SpringBootApplication
class RetryResilience4jConsumerApplication

fun main(args: Array<String>) {
	runApplication<RetryResilience4jConsumerApplication>(*args)
}


