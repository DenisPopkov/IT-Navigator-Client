package ru.popkov.navigator.features.section.ui

import androidx.compose.runtime.Immutable
import ru.popkov.navigator.features.auth.domain.model.Article
import ru.popkov.navigator.features.auth.domain.model.Author
import ru.popkov.navigator.features.auth.domain.model.Poet

@Immutable
internal data class SectionState(

    val authors: List<Author>? = null,
    val articles: List<Article>? = null,
    val poets: List<Poet>? = null,
    val isLoading: Boolean = false,
)
