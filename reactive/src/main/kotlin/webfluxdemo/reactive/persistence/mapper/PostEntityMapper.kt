package webfluxdemo.reactive.persistence.mapper

import webfluxdemo.reactive.dto.AddPostBody
import webfluxdemo.reactive.dto.Post
import webfluxdemo.reactive.dto.UpdatePostBody
import webfluxdemo.reactive.persistence.entity.CommentEntity
import webfluxdemo.reactive.persistence.entity.PostEntity

interface PostEntityMapper {
    fun toPostDto(
        postEntity: PostEntity,
        commentEntities: List<CommentEntity>? = null,
        isBeautiful: Boolean? = null,
    ): Post

    fun toPostEntityAdd(
        addPostBody: AddPostBody,
        userId: String,
    ): PostEntity

    fun toPostEntityUpdate(
        updatePostBody: UpdatePostBody,
        oldPostEntity: PostEntity,
    ): PostEntity
}
