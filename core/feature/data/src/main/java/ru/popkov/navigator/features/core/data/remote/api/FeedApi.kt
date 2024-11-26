package ru.popkov.navigator.features.core.data.remote.api

import retrofit2.http.GET
import ru.popkov.navigator.features.core.data.remote.dtos.Article
import ru.popkov.navigator.features.core.data.remote.dtos.Author
import ru.popkov.navigator.features.core.data.remote.dtos.Poet

interface FeedApi {

    @GET("/authors")
    suspend fun getAuthors(

    ): List<Author>

    @GET("/articles")
    suspend fun getArticles(

    ): List<Article>

    @GET("/poets")
    suspend fun getPoets(

    ): List<Poet>
}
