package ru.popkov.navigator.features.core.data.remote.mappers

import ru.popkov.navigator.features.core.data.remote.dtos.Settings as SettingsDto
import ru.popkov.navigator.features.auth.domain.model.Settings as SettingsDomain

object SettingsMapper {

    fun SettingsDto.toEntity() =
        SettingsDomain(
            name = this.name,
            image = this.image,
        )
}