package webfluxdemo.reactive.controller.exceptionHandling
import org.slf4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import reactor.core.publisher.Mono
import webfluxdemo.reactive.exception.BadRequestException
import webfluxdemo.reactive.exception.Error

@ControllerAdvice
class ControllerExceptionHandler(private val logger: Logger) {
    @ExceptionHandler(Exception::class)
    fun unmappedException(ex: Exception): Mono<ResponseEntity<Error>> =
        logError(ex).run {
            Error
                .internalServerError(ex.message ?: ex.toString())
                .createResponse()
        }

    @ExceptionHandler(BadRequestException::class)
    fun badRequestException(ex: BadRequestException): Mono<ResponseEntity<Error>> =
        logError(ex).run {
            ex.error.createResponse()
        }

    private fun logError(ex: Exception) {
        logger.error("Caught the following exception: {} with message: {}", ex::class, ex.message, ex)
    }
}
