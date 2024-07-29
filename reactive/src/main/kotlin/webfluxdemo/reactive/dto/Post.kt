package webfluxdemo.reactive.dto

import java.util.UUID

data class Post(
    val id: UUID,
    val userId: String,
    val content: String,
    val tags: List<String>,
    val comments: List<Comment>?,
    val isBeautiful: Boolean?,
)
