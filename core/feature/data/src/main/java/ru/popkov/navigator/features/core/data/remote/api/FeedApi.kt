package ru.popkov.navigator.features.core.data.remote.api

import retrofit2.http.GET
import ru.popkov.navigator.features.core.data.remote.dtos.Article
import ru.popkov.navigator.features.core.data.remote.dtos.Company
import ru.popkov.navigator.features.core.data.remote.dtos.Poet

interface FeedApi {

    @GET("/feed")
    suspend fun getCompanies(): List<Company>

    @GET("/article")
    suspend fun getArticles(): List<Article>

    @GET("/course")
    suspend fun getCourses(): List<Poet>
}
