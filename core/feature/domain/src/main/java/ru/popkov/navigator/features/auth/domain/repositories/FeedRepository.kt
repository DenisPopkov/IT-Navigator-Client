package ru.popkov.navigator.features.auth.domain.repositories

import ru.popkov.navigator.features.auth.domain.model.Article
import ru.popkov.navigator.features.auth.domain.model.Author
import ru.popkov.navigator.features.auth.domain.model.Poet

interface FeedRepository {
    suspend fun getAuthors(): List<Author>

    suspend fun getArticles(): List<Article>

    suspend fun getPoets(): List<Poet>

    suspend fun getAuthorsFromLocal(): List<Author>

    suspend fun getArticlesFromLocal(): List<Article>

    suspend fun getPoetsFromLocal(): List<Poet>
}