package ru.popkov.navigator.features.core.data.remote.mappers

import ru.popkov.navigator.features.core.data.local.entities.Article as ArticleEntity
import ru.popkov.navigator.features.core.data.local.entities.Company as AuthorEntity
import ru.popkov.navigator.features.core.data.local.entities.Course as PoetEntity
import ru.popkov.navigator.features.core.data.remote.dtos.Article as ArticleDto
import ru.popkov.navigator.features.core.data.remote.dtos.Company as AuthorDto
import ru.popkov.navigator.features.core.data.remote.dtos.Course as PoetDto

object FeedMapper {

    fun List<AuthorDto>.toListAuthorEntity(): List<AuthorEntity> =
        map { it.toAuthorEntity() }

    fun List<ArticleDto>.toListArticleEntity(): List<ArticleEntity> =
        map { it.toArticleEntity() }

    fun List<PoetDto>.toListPoetEntity(): List<PoetEntity> =
        map { it.toPoetEntity() }

    private fun PoetDto.toPoetEntity(): PoetEntity =
        PoetEntity(
            id = this.id,
            name = this.name,
            image = this.image,
        )

    private fun ArticleDto.toArticleEntity(): ArticleEntity =
        ArticleEntity(
            id = this.id,
            name = this.name,
            description = this.description,
            image = this.image,
        )

    private fun AuthorDto.toAuthorEntity(): AuthorEntity =
        AuthorEntity(
            id = this.id,
            name = this.name,
            image = this.image,
        )
}
