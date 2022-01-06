package io.caused.controller

import io.caused.model.Product
import io.caused.service.UnstableService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono


@RestController
class ConsumerController (var unstableService: UnstableService) {

    @GetMapping("/unstable-client")
    fun unstable(): Mono<Product> {
        return unstableService.unstable()
    }

    @GetMapping("/unstable-with-retry-client")
    fun unstableWithRetry(): Mono<Product> {
        return unstableService.unstableWithRetry()
    }
}