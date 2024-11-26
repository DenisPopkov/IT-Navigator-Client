package ru.popkov.navigator.features.core.data.local.mappers

import ru.popkov.navigator.features.auth.domain.model.Article as ArticlesDomain
import ru.popkov.navigator.features.auth.domain.model.Company as AuthorsDomain
import ru.popkov.navigator.features.auth.domain.model.Poet as PoetsDomain
import ru.popkov.navigator.features.core.data.local.entities.Article as ArticlesEntity
import ru.popkov.navigator.features.core.data.local.entities.Company as AuthorEntity
import ru.popkov.navigator.features.core.data.local.entities.Company as AuthorsEntity
import ru.popkov.navigator.features.core.data.local.entities.Course as PoetsEntity

object FeedMapper {

    private fun AuthorEntity.toAuthorsDomain(): AuthorsDomain =
        AuthorsDomain(
            id = this.id,
            name = this.name,
            image = this.image,
        )

    private fun ArticlesEntity.toArticlesDomain(): ArticlesDomain =
        ArticlesDomain(
            id = this.id,
            name = this.name,
            description = this.description,
            image = this.image,
        )

    private fun PoetsEntity.toPoetsDomain(): PoetsDomain =
        PoetsDomain(
            id = this.id,
            name = this.name,
            image = this.image,
        )

    fun List<AuthorsEntity>.toListAuthorsDomain(): List<AuthorsDomain> =
        map { it.toAuthorsDomain() }

    fun List<ArticlesEntity>.toListArticlesDomain(): List<ArticlesDomain> =
        map { it.toArticlesDomain() }

    fun List<PoetsEntity>.toListPoetsDomain(): List<PoetsDomain> =
        map { it.toPoetsDomain() }
}
