package ru.popkov.navigator.features.info.ui

import androidx.compose.runtime.Immutable
import ru.popkov.navigator.features.auth.domain.model.Article
import ru.popkov.navigator.features.auth.domain.model.Company
import ru.popkov.navigator.features.auth.domain.model.Course

@Immutable
internal data class InfoState(
    val companies: List<Company>? = null,
    val articles: List<Article>? = null,
    val courses: List<Course>? = null,
    val isLoading: Boolean = false,
)
