package webfluxdemo.reactive.persistence.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import webfluxdemo.reactive.persistence.entity.CommentEntity
import java.util.UUID

@Repository
interface CommentRepository : ReactiveCrudRepository<CommentEntity, UUID> {
    fun findAllByPostId(postId: UUID): Flux<CommentEntity>
}
