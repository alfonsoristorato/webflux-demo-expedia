package webfluxdemo.blocking

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.repository.CrudRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.reactive.function.client.WebClient
import webfluxdemo.blocking.dto.Comment
import webfluxdemo.blocking.dto.Post
import webfluxdemo.blocking.dto.PostFilters
import java.sql.Timestamp
import java.util.UUID

@Controller
@RequestMapping(path = ["/post"])
class PostController(private val postService: PostService) {
    @GetMapping("/{postId}/with-comments-zipping-and-is-beautiful")
    fun getPostByIdWithCommentsAndIsBeautiful(
        @PathVariable postId: UUID,
    ): ResponseEntity<Post> {
        val post = postService.getPostByIdWithCommentsAndIsBeautiful(postId)
        return ResponseEntity(post, HttpStatus.OK)
    }

    @PostMapping("/all")
    fun getAllPostsByUserId(
        @RequestBody(required = false) postFilters: PostFilters?,
    ): ResponseEntity<List<Post>> {
        val postList = postService.getAllPostsByUserId(postFilters)
        return ResponseEntity(postList, HttpStatus.OK)
    }
}

@Entity(name = "post")
data class PostEntity(
    @GeneratedValue
    @Id
    val id: UUID,
    @Column(name = "user_id")
    val userId: String,
    val content: String,
    // we do not map tags here as JPA requires converters for List<String>
    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], orphanRemoval = true)
    val comments: MutableList<CommentEntity>,
    @Column(name = "created_at")
    @CreatedDate
    private val createdAt: Timestamp? = null,
    @Column(name = "updated_at")
    @LastModifiedDate
    private val updatedAt: Timestamp? = null,
)

@Entity(name = "comment")
data class CommentEntity(
    @GeneratedValue
    @Id
    val id: UUID,
    @Column(name = "user_id")
    val userId: String,
    val comment: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    val post: PostEntity,
    @Column(name = "created_at")
    @CreatedDate
    private val createdAt: Timestamp? = null,
    @Column(name = "updated_at")
    @LastModifiedDate
    private val updatedAt: Timestamp? = null,
)

@Repository
interface PostRepository : CrudRepository<PostEntity, UUID> {
    fun findAllByUserId(userId: String): List<PostEntity>
}

@Service
class PostService(
    private val postRepository: PostRepository,
    @Value("\${isBeautifulServer.base-endpoint}") private val isBeautifulServerBaseEndpoint: String,
    @Value("\${isBeautifulServer.is-beautiful-path}") private val isBeautifulPath: String,
) {
    private val isBeautifulClient = WebClient.builder().baseUrl(isBeautifulServerBaseEndpoint).build()

    fun getAllPostsByUserId(postFilters: PostFilters?): List<Post> {
        val userId =
            (
                SecurityContextHolder
                    .getContext()
                    .authentication as JwtAuthenticationToken
            ).token.subject

        val postList = postRepository.findAllByUserId(userId)
        return postList.map {
            Post(
                id = it.id,
                userId = it.userId,
                content = it.content,
                tags = emptyList(),
                comments = null,
                isBeautiful = null,
            )
        }
    }

    fun getPostByIdWithCommentsAndIsBeautiful(postId: UUID): Post {
        val post = postRepository.findById(postId).get()
        val isBeautifulPost =
            isBeautifulClient.get()
                .uri(isBeautifulPath)
                .retrieve()
                .bodyToMono(JsonNode::class.java)
                .map { it.get("isBeautiful").asBoolean() }
                .block()
        val comments =
            post.comments.map {
                Comment(
                    userId = it.userId,
                    comment = it.comment,
                )
            }
        return Post(
            id = post.id,
            userId = post.userId,
            content = post.content,
            tags = emptyList(),
            comments = comments,
            isBeautiful = isBeautifulPost,
        )
    }
}
