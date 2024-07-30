package webfluxdemo.reactive.service.impl

import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.util.function.component1
import reactor.kotlin.core.util.function.component2
import reactor.kotlin.core.util.function.component3
import webfluxdemo.reactive.downstream.isBeautiful.service.IsBeautifulService
import webfluxdemo.reactive.dto.AddPostBody
import webfluxdemo.reactive.dto.Post
import webfluxdemo.reactive.dto.PostFilters
import webfluxdemo.reactive.dto.UpdatePostBody
import webfluxdemo.reactive.persistence.mapper.PostEntityMapper
import webfluxdemo.reactive.persistence.repository.CommentRepository
import webfluxdemo.reactive.persistence.repository.PostRepository
import webfluxdemo.reactive.persistence.repository.extensions.ReactiveCrudRepositoryExtensions.findByOrError
import webfluxdemo.reactive.persistence.repository.extensions.ReactiveCrudRepositoryExtensions.findByOrErrorValidatingUserId
import webfluxdemo.reactive.service.PostService
import java.util.UUID

@Service
class PostServiceImpl(
    private val postRepository: PostRepository,
    private val commentRepository: CommentRepository,
    private val postEntityMapper: PostEntityMapper,
    private val isBeautifulService: IsBeautifulService,
) : PostService {
    override fun getPostByIdWithoutComments(postId: UUID): Mono<Post> =
        postRepository
            .findByOrError(postId, "Post")
            .map { postEntityMapper.toPostDto(it) }

    override fun getPostByIdWithCommentsFlatMapping(postId: UUID): Mono<Post> =
        postRepository
            .findByOrError(postId, "Post")
            .flatMap { postEntity ->
                commentRepository
                    .findAllByPostId(postId)
                    .collectList()
                    .map { commentsEntities ->
                        postEntityMapper.toPostDto(postEntity, commentsEntities)
                    }
            }

    override fun getPostByIdWithCommentsZipping(postId: UUID): Mono<Post> =
        postRepository
            .findByOrError(postId, "Post")
            .zipWith(commentRepository.findAllByPostId(postId).collectList())
            .map { (postEntity, commentEntities) ->
                postEntityMapper.toPostDto(postEntity, commentEntities)
            }

    override fun getPostByIdWithCommentsZippingAndIsBeautiful(postId: UUID): Mono<Post> =
        Mono.zip(
            postRepository.findByOrError(postId, "Post"),
            commentRepository.findAllByPostId(postId).collectList(),
            isBeautifulService.isBeautifulResolver(),
        )
            .map { (postEntity, commentEntities, isBeautiful) ->
                postEntityMapper.toPostDto(postEntity, commentEntities, isBeautiful)
            }

    override fun addPost(addPostBody: AddPostBody): Mono<Post> =
        getUserSub()
            .flatMap { userId ->
                postRepository.save(postEntityMapper.toPostEntityAdd(addPostBody, userId))
                    .map { postEntityMapper.toPostDto(it) }
            }

    override fun updatePost(
        updatePostBody: UpdatePostBody,
        postId: UUID,
    ): Mono<Post> =
        getUserSub()
            .flatMap { userId ->
                Mono.zip(
                    postRepository.findByOrErrorValidatingUserId(
                        postId,
                        "Post",
                        { postEntity -> postEntity.userId == userId },
                    ),
                    commentRepository.findAllByPostId(postId).collectList(),
                    isBeautifulService.isBeautifulResolver(),
                )
                    .flatMap { (oldPostEntity, commentEntities, isBeautiful) ->
                        postRepository.save(
                            postEntityMapper.toPostEntityUpdate(updatePostBody, oldPostEntity),
                        ).map { newPostEntity ->
                            postEntityMapper.toPostDto(newPostEntity, commentEntities, isBeautiful)
                        }
                    }
            }

    override fun deletePost(postId: UUID): Mono<Void> =
        getUserSub()
            .flatMap { userId ->
                postRepository.findByOrErrorValidatingUserId(
                    postId,
                    "Post",
                    { postEntity -> postEntity.userId == userId },
                )
                    .flatMap {
                        postRepository.deleteById(postId)
                    }
            }

    override fun getAllPostsByUserId(postFilters: PostFilters?): Flux<Post> =
        getUserSub()
            .flatMapMany { userId ->
                postRepository.findAllByUserId(userId)
//                    .filter { postEntity ->
//                        postFilters?.tags?.let { tags -> postEntity.tags.containsAll(tags) } ?: true
//                    }
                    .map { postEntityMapper.toPostDto(it) }
            }

    override fun getAllPostsByUserIdWithCustomQuery(postFilters: PostFilters?): Flux<Post> =
        getUserSub()
            .flatMapMany { userId ->
                postRepository.findAllByUserIdAndFilters(userId, postFilters)
                    .map { postEntityMapper.toPostDto(it) }
            }

    private fun getUserSub(): Mono<String> =
        ReactiveSecurityContextHolder
            .getContext()
            .map {
                (it.authentication as JwtAuthenticationToken).token.subject
            }
}
