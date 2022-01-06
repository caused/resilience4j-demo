package io.caused.controller

import io.caused.model.Product
import io.caused.service.UnstableService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.function.Function


@RestController
class ConsumerController (var unstableService: UnstableService) {

    @Autowired
    private lateinit var reactiveCircuitBreakerFactory: ReactiveCircuitBreakerFactory<*, *>

    @GetMapping("/unstable-client")
    fun unstable(): Mono<Product> {
        return unstableService.unstable()
    }

    @GetMapping("/unstable-with-retry-client")
    fun unstableWithRetry(): Mono<Product> {
        return reactiveCircuitBreakerFactory
            .create("unstableService")
            .run(unstableService.unstableWithRetry(), Function {
                Mono.just(Product("DVD", 230.0))
            })
    }
}