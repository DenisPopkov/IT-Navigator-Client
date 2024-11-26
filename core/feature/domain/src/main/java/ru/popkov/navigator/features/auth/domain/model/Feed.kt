package ru.popkov.navigator.features.auth.domain.model

import com.google.errorprone.annotations.Keep

@Keep
data class Company(
    val id: Long,
    val name: String,
    val image: String,
)

@Keep
data class Article(
    val id: Long,
    val name: String,
    val description: String,
    val image: String,
)

@Keep
data class Course(
    val id: Long,
    val name: String,
    val image: String,
)
