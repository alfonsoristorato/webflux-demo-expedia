package webfluxdemo.reactive.persistence.mapper.impl

import org.springframework.stereotype.Component
import webfluxdemo.reactive.dto.AddPostBody
import webfluxdemo.reactive.dto.Comment
import webfluxdemo.reactive.dto.Post
import webfluxdemo.reactive.dto.UpdatePostBody
import webfluxdemo.reactive.persistence.entity.CommentEntity
import webfluxdemo.reactive.persistence.entity.PostEntity
import webfluxdemo.reactive.persistence.mapper.PostEntityMapper
import java.util.UUID

@Component
class PostEntityMapperImpl : PostEntityMapper {
    override fun toPostDto(
        postEntity: PostEntity,
        commentEntities: List<CommentEntity>?,
        isBeautiful: Boolean?,
    ): Post =
        Post(
            id = postEntity.id!!,
            userId = postEntity.userId,
            content = postEntity.content,
            tags = postEntity.tags,
            comments =
                commentEntities?.map {
                    Comment(
                        userId = it.userId,
                        comment = it.comment,
                    )
                },
            isBeautiful = isBeautiful,
        )

    @Suppress("UNCHECKED_CAST")
    override fun toPostDto(
        dbResult: Map<String, Any>,
        commentEntities: List<CommentEntity>?,
        isBeautiful: Boolean?,
    ): Post =
        Post(
            id = dbResult["id"] as UUID,
            userId = dbResult["user_id"] as String,
            content = dbResult["content"] as String,
            tags = (dbResult["tags"] as? Array<String>?)?.toList() ?: emptyList(),
            comments =
                commentEntities?.map {
                    Comment(
                        userId = it.userId,
                        comment = it.comment,
                    )
                },
            isBeautiful = isBeautiful,
        )

    override fun toPostEntityAdd(
        addPostBody: AddPostBody,
        userId: String,
    ): PostEntity =
        PostEntity(
            userId = userId,
            content = addPostBody.content,
            tags = addPostBody.tags,
        )

    override fun toPostEntityUpdate(
        updatePostBody: UpdatePostBody,
        oldPostEntity: PostEntity,
    ): PostEntity =
        oldPostEntity.copy(
            content = updatePostBody.content,
            tags = updatePostBody.tags,
        )
}
