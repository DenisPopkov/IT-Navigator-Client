package ru.popkov.navigator.features.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.popkov.navigator.features.core.data.local.daos.FeedDao
import ru.popkov.navigator.features.core.data.local.daos.UserDao
import ru.popkov.navigator.features.core.data.local.entities.Article
import ru.popkov.navigator.features.core.data.local.entities.Author
import ru.popkov.navigator.features.core.data.local.entities.Poet
import ru.popkov.navigator.features.core.data.local.entities.UserData

@Database(
    entities = [
        UserData::class,
        Author::class,
        Article::class,
        Poet::class,
    ],
    version = 8,
    exportSchema = false,
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun feedDao(): FeedDao

    abstract fun userDao(): UserDao
}
