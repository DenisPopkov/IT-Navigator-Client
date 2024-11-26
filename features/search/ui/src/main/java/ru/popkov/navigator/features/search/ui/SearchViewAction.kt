package ru.popkov.navigator.features.search.ui

import ru.popkov.android.core.feature.components.core.models.SectionType

sealed interface SearchViewAction {
    data object OnMainScreenClick : SearchViewAction
    data class OnSectionItemClick(val sectionType: SectionType) : SearchViewAction
    data class OnSearchChange(val searchText: String) : SearchViewAction
    data class OnSectionClick(val sectionId: Int) : SearchViewAction
    data class OnCardClick(val cardId: Long) : SearchViewAction
}