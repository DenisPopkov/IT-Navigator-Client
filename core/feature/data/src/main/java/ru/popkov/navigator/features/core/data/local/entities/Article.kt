package ru.popkov.navigator.features.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
    @PrimaryKey
    val id: Long,
    val name: String,
    val description: String,
    val image: String,
)
