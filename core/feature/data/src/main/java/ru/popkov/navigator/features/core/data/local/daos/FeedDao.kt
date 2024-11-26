package ru.popkov.navigator.features.core.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import ru.popkov.navigator.features.core.data.local.entities.Article
import ru.popkov.navigator.features.core.data.local.entities.Company
import ru.popkov.navigator.features.core.data.local.entities.Course

@Dao
abstract class FeedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addAuthors(vararg company: Company)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addArticles(vararg article: Article)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addPoets(vararg course: Course)

    @Query("SELECT * FROM company")
    abstract suspend fun getAuthors(): List<Company>

    @Query("SELECT * FROM article")
    abstract suspend fun getArticles(): List<Article>

    @Query("SELECT * FROM course")
    abstract suspend fun getPoets(): List<Course>

    @Transaction
    @Query("SELECT * FROM company WHERE id = :authorId")
    abstract suspend fun findAuthorById(authorId: Long): Company

    @Transaction
    @Query("SELECT * FROM article WHERE id = :articleId")
    abstract suspend fun findArticleById(articleId: Long): Article

    @Transaction
    @Query("SELECT * FROM course WHERE id = :poetId")
    abstract suspend fun findPoetById(poetId: Long): Course
}
