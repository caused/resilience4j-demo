package io.caused

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RetryResilience4jProducerApplication

fun main(args: Array<String>) {
	runApplication<RetryResilience4jProducerApplication>(*args)
}
