package webfluxdemo.reactive.service

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import webfluxdemo.reactive.dto.AddPostBody
import webfluxdemo.reactive.dto.Post
import webfluxdemo.reactive.dto.PostFilters
import webfluxdemo.reactive.dto.UpdatePostBody
import java.util.UUID

interface PostService {
    fun getPostByIdWithoutComments(postId: UUID): Mono<Post>

    fun getPostByIdWithCommentsFlatMapping(postId: UUID): Mono<Post>

    fun getPostByIdWithCommentsZipping(postId: UUID): Mono<Post>

    fun getPostByIdWithCommentsZippingAndIsBeautiful(postId: UUID): Mono<Post>

    fun addPost(addPostBody: AddPostBody): Mono<Post>

    fun updatePost(updatePostBody: UpdatePostBody, postId: UUID): Mono<Post>
    fun deletePost(postId: UUID): Mono<Void>
    fun getAllPostsByUserId(postFilters: PostFilters?): Flux<Post>
    fun getAllPostsByUserIdWithCustomQuery(postFilters: PostFilters?): Flux<Post>
}
