package webfluxdemo.reactive.dto

import java.util.UUID

data class AddPostBody(
    val content: String,
    val tags: List<String>,
)
