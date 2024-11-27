package ru.popkov.navigator.features.auth.domain.model

import com.google.errorprone.annotations.Keep

@Keep
data class Company(
    val id: Long,
    val name: String,
    val image: String,
    val date: String? = null,
    val desc: String? = null,
)

@Keep
data class Article(
    val id: Long,
    val name: String,
    val date: String? = null,
    val description: String,
    val image: String,
)

@Keep
data class Course(
    val id: Long,
    val name: String,
    val date: String? = null,
    val desc: String? = null,
    val image: String,
)
