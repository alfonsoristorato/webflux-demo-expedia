package webfluxdemo.reactive.downstream.isBeautiful.service.impl

import com.fasterxml.jackson.databind.JsonNode
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import webfluxdemo.reactive.downstream.isBeautiful.service.IsBeautifulService

@Service
class IsBeautifulServiceImpl(
    private val isBeautifulClient: WebClient,
    @Value("\${isBeautifulServer.is-beautiful-path}") private val isBeautifulPath: String,
) : IsBeautifulService {
    override fun isBeautifulResolver(): Mono<Boolean> =
        isBeautifulClient
            .get()
            .uri(isBeautifulPath)
            .retrieve()
            .bodyToMono(JsonNode::class.java)
            .map { it.get("isBeautiful").asBoolean() }
}
