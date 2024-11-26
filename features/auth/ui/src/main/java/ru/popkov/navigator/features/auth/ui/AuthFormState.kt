package ru.popkov.navigator.features.auth.ui

import androidx.compose.runtime.Immutable

enum class AuthGlobalState {
    REGISTER_NEW_USER_EMAIL,
    REGISTER_NEW_USER_PASSWORD,
    AUTH,
    ;
}

@Immutable
internal data class AuthFormState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val authGlobalState: AuthGlobalState = AuthGlobalState.REGISTER_NEW_USER_EMAIL,
)