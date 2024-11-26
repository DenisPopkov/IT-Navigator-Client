package ru.popkov.navigator.features.auth.domain.model

data class ValidationResult(
    val successful: Boolean = false,
    val errorMessage: String? = null,
)