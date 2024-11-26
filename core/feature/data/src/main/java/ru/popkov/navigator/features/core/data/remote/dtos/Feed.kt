package ru.popkov.navigator.features.core.data.remote.dtos

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Company(
    val id: Long,
    val name: String,
    val image: String,
)

@Keep
@JsonClass(generateAdapter = true)
data class Article(
    val id: Long,
    val name: String,
    val description: String,
    val image: String,
)

@Keep
@JsonClass(generateAdapter = true)
data class Course(
    val id: Long,
    val name: String,
    val image: String,
)