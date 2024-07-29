package webfluxdemo.reactive.downstream.isBeautiful.client.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class IsBeautifulClientConfig(
    @Value("\${isBeautifulServer.base-endpoint}") private val baseEndpoint: String,
) {
    @Bean
    fun isBeautifulClient(): WebClient = WebClient.builder().baseUrl(baseEndpoint).build()
}
