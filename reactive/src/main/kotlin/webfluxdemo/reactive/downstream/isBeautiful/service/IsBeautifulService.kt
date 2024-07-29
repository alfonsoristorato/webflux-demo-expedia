package webfluxdemo.reactive.downstream.isBeautiful.service

import reactor.core.publisher.Mono

interface IsBeautifulService {
    fun isBeautifulResolver(): Mono<Boolean>
}
