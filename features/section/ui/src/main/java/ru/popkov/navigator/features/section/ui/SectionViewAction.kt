package ru.popkov.navigator.features.section.ui

sealed interface SectionViewAction {
    data object OnBackClick : SectionViewAction
    data class OnCardClick(val cardId: Long) : SectionViewAction
}