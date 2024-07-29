package webfluxdemo.reactive.persistence.repository.extensions

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.http.HttpStatus
import reactor.core.publisher.Mono
import webfluxdemo.reactive.exception.BadRequestException
import webfluxdemo.reactive.exception.Error
import java.util.UUID

object ReactiveCrudRepositoryExtensions {
    fun <T> ReactiveCrudRepository<T, UUID>.findByOrError(
        id: UUID,
        entityName: String,
        action: (UUID) -> Mono<T> = { this.findById(id) },
    ): Mono<T> =
        action(id)
            .switchIfEmpty(
                Mono.error(
                    BadRequestException(
                        Error.badRequestError(
                            "$entityName not found",
                            HttpStatus.NOT_FOUND,
                        ),
                    ),
                ),
            )

    fun <T> ReactiveCrudRepository<T, UUID>.findByOrErrorValidatingUserId(
        id: UUID,
        entityName: String,
        validateEntity: (T) -> Boolean,
        action: (UUID) -> Mono<T> = { this.findById(id) },
    ): Mono<T> =
        findByOrError(id, entityName, action)
            .filter { validateEntity(it) }
            .switchIfEmpty(
                Mono.error(
                    BadRequestException(
                        Error.badRequestError(
                            "$entityName cannot be accessed",
                            HttpStatus.UNAUTHORIZED,
                        ),
                    ),
                ),
            )
}
