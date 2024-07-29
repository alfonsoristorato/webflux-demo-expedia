package webfluxdemo.reactive.persistence.repository

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import webfluxdemo.reactive.dto.PostFilters

@Repository
interface PostCustomRepository {
    fun findAllByUserIdAndFilters(
        userId: String,
        postFilters: PostFilters?,
    ): Flux<Map<String, Any>>
}
