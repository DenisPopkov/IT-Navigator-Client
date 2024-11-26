package ru.popkov.navigator.features.core.data.repositories

import ru.popkov.datastore.token.Token
import ru.popkov.navigator.features.auth.domain.model.Settings
import ru.popkov.navigator.features.auth.domain.repositories.SettingsRepository
import ru.popkov.navigator.features.core.data.remote.api.SettingsApi
import ru.popkov.navigator.features.core.data.remote.mappers.SettingsMapper.toEntity
import se.ansman.dagger.auto.AutoBind
import javax.inject.Inject
import javax.inject.Singleton

@AutoBind
@Singleton
class SettingsRepository @Inject constructor(
    private val settingsApi: SettingsApi,
    private val tokenDataStore: Token,
) : SettingsRepository {
    override suspend fun getSettings(): Settings {
        return settingsApi.getSettings().toEntity()
    }

    override suspend fun deleteUserAccount() {
        settingsApi.deleteUserAccount()
        tokenDataStore.deleteToken()
    }

}