package webfluxdemo.reactive.dto

data class AddPostBody(
    val content: String,
    val tags: List<String>,
)
