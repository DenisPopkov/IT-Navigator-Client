package ru.popkov.navigator.features.auth.ui

internal sealed interface AuthViewEffect {

    data class ShowError(val errorMessage: String): AuthViewEffect
    data object GoToMainScreen : AuthViewEffect
}