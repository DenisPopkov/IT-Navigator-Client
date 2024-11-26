package ru.popkov.navigator.features.core.data.repositories

import ru.popkov.navigator.features.auth.domain.model.Article
import ru.popkov.navigator.features.auth.domain.model.Company
import ru.popkov.navigator.features.auth.domain.model.Poet
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

    override suspend fun getAuthors(): List<Company> {
        val authors = feedApi.getAuthors()
        feedDao.addAuthors(*authors.toListAuthorEntity().toTypedArray())
        return feedDao.getAuthors().toListAuthorsDomain()
    }

    override suspend fun getArticles(): List<Article> {
        val articles = feedApi.getArticles()
        feedDao.addArticles(*articles.toListArticleEntity().toTypedArray())
        return feedDao.getArticles().toListArticlesDomain()
    }

    override suspend fun getPoets(): List<Poet> {
        val courses = feedApi.getPoets()
        feedDao.addPoets(*courses.toListPoetEntity().toTypedArray())
        return feedDao.getPoets().toListPoetsDomain()
    }

    override suspend fun getAuthorsFromLocal(): List<Company> {
        return feedDao.getAuthors().toListAuthorsDomain()
    }

    override suspend fun getArticlesFromLocal(): List<Article> {
        return feedDao.getArticles().toListArticlesDomain()
    }

    override suspend fun getPoetsFromLocal(): List<Poet> {
        return feedDao.getPoets().toListPoetsDomain()
    }

}