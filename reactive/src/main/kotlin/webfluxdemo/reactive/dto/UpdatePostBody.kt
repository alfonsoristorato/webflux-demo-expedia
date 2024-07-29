package webfluxdemo.reactive.dto

import java.util.UUID

data class UpdatePostBody(
    val id: UUID,
    val content: String,
    val tags: List<String>,
)
