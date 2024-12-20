package ru.popkov.navigator.features.settings.ui

internal sealed interface SettingsViewEffect {

    data class ShowError(val errorMessage: String) : SettingsViewEffect
    data object OnDeleteAccountClick : SettingsViewEffect
    data object OnExitAccountClick : SettingsViewEffect
}