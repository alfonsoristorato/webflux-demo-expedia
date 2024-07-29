package webfluxdemo.reactive.persistence.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp
import java.util.UUID

@Table(name = "post")
data class PostEntity(
    @JvmField
    @Id
    var id: UUID? = null,
    @Column("user_id")
    val userId: String,
    val content: String,
    val tags: List<String>,
    @Column("created_at")
    @CreatedDate
    private val createdAt: Timestamp? = null,
    @Column("updated_at")
    @LastModifiedDate
    private val updatedAt: Timestamp? = null,
) : Persistable<UUID?> {
    override fun getId(): UUID? = id

    override fun isNew(): Boolean =
        if (id == null) {
            id = UUID.randomUUID()
            true
        } else {
            false
        }
}
