package ru.popkov.navigator.features.auth.domain.repositories

import ru.popkov.navigator.features.auth.domain.model.Article
import ru.popkov.navigator.features.auth.domain.model.Company
import ru.popkov.navigator.features.auth.domain.model.Course

interface FeedRepository {
    suspend fun getCompanies(): List<Company>

    suspend fun getArticles(): List<Article>

    suspend fun getCourses(): List<Course>

    suspend fun getAuthorsFromLocal(): List<Company>

    suspend fun getArticlesFromLocal(): List<Article>

    suspend fun getPoetsFromLocal(): List<Course>
}