package ru.popkov.navigator.features.search.ui

internal sealed interface SearchViewEffect {

    data object GoToMainScreen : SearchViewEffect

    data class ShowError(val errorMessage: String) : SearchViewEffect
    data class OnSectionClick(val sectionId: Int) : SearchViewEffect
    data class OnCardClick(val cardId: Long) : SearchViewEffect
}