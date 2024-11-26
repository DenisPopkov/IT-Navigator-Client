package ru.popkov.navigator.features.auth.ui

sealed interface AuthViewAction {

    data object OnAlreadyHaveAccountClick : AuthViewAction
    data object OnNoAccountClick : AuthViewAction
    data object OnDone : AuthViewAction
    data class OnPasswordChange(val password: String) : AuthViewAction
    data class OnEmailChange(val email: String) : AuthViewAction
}