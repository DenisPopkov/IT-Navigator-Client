package ru.popkov.navigator.features.section.ui

sealed interface SectionViewAction {
    data object OnBackClick : SectionViewAction
    data class OnSectionClick(val cardId: Long) : SectionViewAction

    data class OnCardClick(val cardId: Long) : SectionViewAction
}