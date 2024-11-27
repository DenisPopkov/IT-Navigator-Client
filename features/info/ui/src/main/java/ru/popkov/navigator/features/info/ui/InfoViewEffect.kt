package ru.popkov.navigator.features.info.ui

internal sealed interface InfoViewEffect {
    data object OnBackClick : InfoViewEffect
    data class ShowError(val errorMessage: String) : InfoViewEffect
}