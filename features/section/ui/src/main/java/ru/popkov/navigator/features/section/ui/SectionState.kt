package ru.popkov.navigator.features.section.ui

import androidx.compose.runtime.Immutable
import ru.popkov.navigator.features.auth.domain.model.Article
import ru.popkov.navigator.features.auth.domain.model.Company
import ru.popkov.navigator.features.auth.domain.model.Poet

@Immutable
internal data class SectionState(

    val authors: List<Company>? = null,
    val articles: List<Article>? = null,
    val courses: List<Poet>? = null,
    val isLoading: Boolean = false,
)
