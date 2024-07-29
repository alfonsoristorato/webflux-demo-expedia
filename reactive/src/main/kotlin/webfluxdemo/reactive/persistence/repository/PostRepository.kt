package webfluxdemo.reactive.persistence.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import webfluxdemo.reactive.persistence.entity.PostEntity
import java.util.UUID

@Repository
interface PostRepository : ReactiveCrudRepository<PostEntity, UUID>, PostCustomRepository {
    fun findAllByUserId(userId: String): Flux<PostEntity>
}
