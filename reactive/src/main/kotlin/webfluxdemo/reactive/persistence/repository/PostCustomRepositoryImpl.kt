package webfluxdemo.reactive.persistence.repository

import org.springframework.r2dbc.core.DatabaseClient
import reactor.core.publisher.Flux
import webfluxdemo.reactive.dto.PostFilters

class PostCustomRepositoryImpl(private val databaseClient: DatabaseClient) : PostCustomRepository {
    override fun findAllByUserIdAndFilters(
        userId: String,
        postFilters: PostFilters?,
    ): Flux<Map<String, Any>> {
        val baseSelectQuery = StringBuilder("SELECT * FROM post where user_id = :userId")

        val bindValues: MutableMap<String, Any> = mutableMapOf("userId" to userId)

        return databaseClient
            .sql(
                buildQueryFromPostFilters(
                    postFilters,
                    baseSelectQuery,
                    bindValues,
                ).toString(),
            )
            .bindValues(bindValues)
            .fetch()
            .all()
    }

    private fun buildQueryFromPostFilters(
        postFilters: PostFilters?,
        query: StringBuilder,
        bindValues: MutableMap<String, Any>,
    ): StringBuilder {
        postFilters?.let {
            if (it.tags != null) {
                it.tags.forEachIndexed { index, tag ->
                    query.append(" AND :tag$index = ANY(tags)")
                    bindValues["tag$index"] = tag.uppercase()
                }
            }
        }

        return query
    }
}
