package webfluxdemo.reactive.exception

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Mono

data class Error(
    val description: String,
    val details: String,
    @JsonIgnore val statusCode: HttpStatusCode,
) {
    companion object {
        fun badRequestError(
            details: String,
            statusCode: HttpStatusCode = HttpStatus.BAD_REQUEST,
        ) = Error("Bad Request Error", details, statusCode)

        fun internalServerError(
            details: String,
            statusCode: HttpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR,
        ) = Error("Internal Server Error", details, statusCode)
    }

    fun createResponse(): Mono<ResponseEntity<Error>> = Mono.just(ResponseEntity.status(statusCode).body(this))
}
