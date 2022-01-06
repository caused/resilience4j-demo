package io.caused.service

import io.caused.model.Product
import io.github.resilience4j.retry.annotation.Retry
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@Service
class UnstableService (var webClient: WebClient) {
    private var UNSTABLE_SERVICE : String = "unstableService"

    fun unstable() : Mono<Product> {
        return webClient.get().uri("/unstable").retrieve().bodyToMono(Product::class.java)
    }

    @Retry(name = "\${UNSTABLE_SERVICE}", fallbackMethod = "defaultProduct")
    fun unstableWithRetry() : Mono<Product>{
        return webClient.get().uri("/unstable").retrieve().bodyToMono(Product::class.java)
    }

    fun defaultProduct() : Mono<Product>{
        return Mono.just(Product("DVD", 12.0))
    }
}