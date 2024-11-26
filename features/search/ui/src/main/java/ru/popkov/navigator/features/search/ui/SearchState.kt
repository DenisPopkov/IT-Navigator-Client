package ru.popkov.navigator.features.search.ui

import androidx.compose.runtime.Immutable
import ru.popkov.android.core.feature.components.core.models.SectionFilterItem
import ru.popkov.android.core.feature.components.core.models.SectionType
import ru.popkov.navigator.features.auth.domain.model.Article
import ru.popkov.navigator.features.auth.domain.model.Company
import ru.popkov.navigator.features.auth.domain.model.Course

@Immutable
internal data class SearchState(

    val filterList: List<SectionFilterItem> = mutableListOf(
        SectionFilterItem(sectionType = SectionType.ALL, isSectionSelected = true),
        SectionFilterItem(sectionType = SectionType.COMPANY),
        SectionFilterItem(sectionType = SectionType.ARTICLE),
        SectionFilterItem(sectionType = SectionType.COURSE),
    ),
    val authors: List<Company>? = null,
    val articles: List<Article>? = null,
    val courses: List<Course>? = null,
    val isEmptyState: Boolean = false,
    val isLoading: Boolean = false,
)
