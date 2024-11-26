package ru.popkov.navigator.features.auth.domain.repositories

import ru.popkov.navigator.features.auth.domain.model.Settings

interface SettingsRepository {
    suspend fun getSettings(): Settings
    suspend fun deleteUserAccount()
}