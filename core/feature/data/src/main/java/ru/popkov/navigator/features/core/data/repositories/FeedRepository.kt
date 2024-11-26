package ru.popkov.navigator.features.core.data.repositories

import ru.popkov.navigator.features.auth.domain.model.Article
import ru.popkov.navigator.features.auth.domain.model.Company
import ru.popkov.navigator.features.auth.domain.model.Course
import ru.popkov.navigator.features.auth.domain.repositories.FeedRepository
import ru.popkov.navigator.features.core.data.local.daos.FeedDao
import ru.popkov.navigator.features.core.data.local.mappers.FeedMapper.toListArticlesDomain
import ru.popkov.navigator.features.core.data.local.mappers.FeedMapper.toListAuthorsDomain
import ru.popkov.navigator.features.core.data.local.mappers.FeedMapper.toListPoetsDomain
import ru.popkov.navigator.features.core.data.remote.api.FeedApi
import ru.popkov.navigator.features.core.data.remote.mappers.FeedMapper.toListArticleEntity
import ru.popkov.navigator.features.core.data.remote.mappers.FeedMapper.toListAuthorEntity
import ru.popkov.navigator.features.core.data.remote.mappers.FeedMapper.toListPoetEntity
import se.ansman.dagger.auto.AutoBind
import javax.inject.Inject
import javax.inject.Singleton

@AutoBind
@Singleton
class FeedRepository @Inject constructor(
    private val feedApi: FeedApi,
    private val feedDao: FeedDao,
) : FeedRepository {

    override suspend fun getCompanies(): List<Company> {
        val authors = feedApi.getCompanies()
        feedDao.addAuthors(*authors.toListAuthorEntity().toTypedArray())
        return feedDao.getCompanies().toListAuthorsDomain()
    }

    override suspend fun getArticles(): List<Article> {
        val articles = feedApi.getArticles()
        feedDao.addArticles(*articles.toListArticleEntity().toTypedArray())
        return feedDao.getArticles().toListArticlesDomain()
    }

    override suspend fun getCourses(): List<Course> {
        val courses = feedApi.getCourses()
        feedDao.addPoets(*courses.toListPoetEntity().toTypedArray())
        return feedDao.getCourses().toListPoetsDomain()
    }

    override suspend fun getAuthorsFromLocal(): List<Company> {
        return feedDao.getCompanies().toListAuthorsDomain()
    }

    override suspend fun getArticlesFromLocal(): List<Article> {
        return feedDao.getArticles().toListArticlesDomain()
    }

    override suspend fun getPoetsFromLocal(): List<Course> {
        return feedDao.getCourses().toListPoetsDomain()
    }

}