package ru.popkov.navigator.features.auth.domain.usecase

import ru.popkov.navigator.features.auth.domain.model.ValidationResult
import javax.inject.Inject

private val EMAIL_REGEX =
    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()

class ValidateEmail @Inject constructor() {

    operator fun invoke(email: String): ValidationResult {
        if (!EMAIL_REGEX.matches(email)) {
            return ValidationResult(
                successful = false,
                errorMessage = "Ошибка валидации"
            )
        }

        return ValidationResult(
            successful = true,
        )
    }
}
