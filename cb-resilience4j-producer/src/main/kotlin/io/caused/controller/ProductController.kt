package io.caused.controller

import io.caused.model.Product
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*

@RestController
class ProductController {

    var BOUND : Int = 5;
    private var logger : Logger = LoggerFactory.getLogger("PRODUCER")

    @GetMapping("/unstable")
    fun unstable() : Mono<Product> {
        logger.info("unstable endpoint called");
        if(Random().nextInt(BOUND)==1){
            logger.error("unstable endpoint called returning Exception");
            throw Exception("oups something bad has happend");
        }
        return Mono.just(Product("TV",350.00))
    }
}