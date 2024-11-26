package ru.popkov.navigator.features.home.ui

sealed interface HomeViewAction {
    data class OnCardClick(val cardId: Long) : HomeViewAction
    data class OnSectionClick(val sectionId: Int) : HomeViewAction
}