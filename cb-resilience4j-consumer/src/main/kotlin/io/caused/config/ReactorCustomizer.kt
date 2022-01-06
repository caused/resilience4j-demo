package io.caused.config

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
import io.github.resilience4j.timelimiter.TimeLimiterConfig
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder
import org.springframework.cloud.client.circuitbreaker.Customizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ReactorCustomizer {

    @Bean
    fun defaultCustomizer(): Customizer<ReactiveResilience4JCircuitBreakerFactory> {
        return Customizer {
            it.configureDefault {
                Resilience4JConfigBuilder.Resilience4JCircuitBreakerConfiguration()
                    .apply {
                        id = "default"
                        circuitBreakerConfig = CircuitBreakerConfig.ofDefaults()
                        timeLimiterConfig = TimeLimiterConfig.ofDefaults()

                    }
            }
        }
    }
}