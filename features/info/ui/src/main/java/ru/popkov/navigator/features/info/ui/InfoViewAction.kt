package ru.popkov.navigator.features.info.ui

sealed interface InfoViewAction {
    data object OnBackClick : InfoViewAction
}