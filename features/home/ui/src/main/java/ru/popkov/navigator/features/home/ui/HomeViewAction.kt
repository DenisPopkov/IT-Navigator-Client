package ru.popkov.navigator.features.home.ui

sealed interface HomeViewAction {
    data class OnCardClick(val cardId: Long, val sectionId: Int) : HomeViewAction
    data class OnSectionClick(val sectionId: Int) : HomeViewAction
}