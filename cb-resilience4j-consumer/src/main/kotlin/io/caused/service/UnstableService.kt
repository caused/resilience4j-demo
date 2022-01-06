package io.caused.service

import io.caused.model.Product
import io.github.resilience4j.retry.annotation.Retry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class UnstableService (var webClient: WebClient) {


    fun unstable() : Mono<Product> {
        return webClient.get().uri("/unstable").retrieve().bodyToMono(Product::class.java)
    }

    fun unstableWithRetry() : Mono<Product>{
        return webClient.get().uri("/unstable").retrieve().bodyToMono(Product::class.java)
    }

}