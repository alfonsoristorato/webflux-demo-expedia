package webfluxdemo.reactive.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import reactor.core.publisher.Mono
import webfluxdemo.reactive.dto.AddPostBody
import webfluxdemo.reactive.dto.Post
import webfluxdemo.reactive.dto.PostFilters
import webfluxdemo.reactive.dto.UpdatePostBody
import webfluxdemo.reactive.service.PostService
import java.util.UUID

@Controller
@RequestMapping(path = ["/post"])
class PostController(private val postService: PostService) {
    // show how to use map
    @GetMapping("/{postId}/without-comments")
    fun getPostByIdWithoutComments(
        @PathVariable postId: UUID,
    ): Mono<ResponseEntity<Post>> =
        postService.getPostByIdWithoutComments(postId)
            .map { ResponseEntity(it, HttpStatus.OK) }

    // show how to use flatMap
    @GetMapping("/{postId}/with-comments-flatMapping")
    fun getPostByIdWithCommentsFlatMapping(
        @PathVariable postId: UUID,
    ): Mono<ResponseEntity<Post>> =
        postService.getPostByIdWithCommentsFlatMapping(postId)
            .map { ResponseEntity(it, HttpStatus.OK) }

    // show how to use zipWith
    @GetMapping("/{postId}/with-comments-zipping")
    fun getPostByIdWithCommentsZipping(
        @PathVariable postId: UUID,
    ): Mono<ResponseEntity<Post>> =
        postService.getPostByIdWithCommentsZipping(postId)
            .map { ResponseEntity(it, HttpStatus.OK) }

    // show how to use Mono.zip
    @GetMapping("/{postId}/with-comments-zipping-and-is-beautiful")
    fun getPostByIdWithCommentsZippingAndIsBeautiful(
        @PathVariable postId: UUID,
    ): Mono<ResponseEntity<Post>> =
        postService.getPostByIdWithCommentsZippingAndIsBeautiful(postId)
            .map { ResponseEntity(it, HttpStatus.OK) }

    // show how save understands that this is a new entity via @Id
    @PostMapping("/add")
    fun addPost(
        @RequestBody addPostBody: AddPostBody,
    ): Mono<ResponseEntity<Post>> =
        postService.addPost(addPostBody)
            .map { ResponseEntity(it, HttpStatus.CREATED) }

    // show userId checks
    @PutMapping("/update/{postId}")
    fun updatePost(
        @PathVariable postId: UUID,
        @RequestBody updatePostBody: UpdatePostBody,
    ): Mono<ResponseEntity<Post>> =
        postService.updatePost(updatePostBody, postId)
            .map { ResponseEntity(it, HttpStatus.CREATED) }

    // show why map would not work here
    @DeleteMapping("/delete/{postId}")
    fun deletePost(
        @PathVariable postId: UUID,
    ): Mono<ResponseEntity<Void>> =
        postService.deletePost(postId)
            .thenReturn(ResponseEntity(HttpStatus.NO_CONTENT))

    // show how to filter db results with flux
    @PostMapping("/all")
    fun getAllPostsByUserId(
        @RequestBody(required = false) postFilters: PostFilters?,
    ): Mono<ResponseEntity<List<Post>>> =
        postService.getAllPostsByUserId(postFilters)
            .collectList()
            .map { ResponseEntity(it, HttpStatus.OK) }

    // show how to filter db results with custom query
    @PostMapping("/all/with-custom-query")
    fun getAllPostsByUserIdUsingCustomQuery(
        @RequestBody(required = false) postFilters: PostFilters?,
    ): Mono<ResponseEntity<List<Post>>> =
        postService.getAllPostsByUserIdWithCustomQuery(postFilters)
            .collectList()
            .map { ResponseEntity(it, HttpStatus.OK) }
}
