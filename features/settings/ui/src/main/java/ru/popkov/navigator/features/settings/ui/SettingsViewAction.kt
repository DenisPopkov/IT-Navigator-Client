package ru.popkov.navigator.features.settings.ui

sealed interface SettingsViewAction {
    data object OnDeleteAccountClick : SettingsViewAction
    data object OnExitAccountClick : SettingsViewAction
    data object OnChangeModeClick : SettingsViewAction
}