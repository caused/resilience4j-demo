package io.caused

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RetryResilience4jConsumerApplication

fun main(args: Array<String>) {
	runApplication<RetryResilience4jConsumerApplication>(*args)
}
