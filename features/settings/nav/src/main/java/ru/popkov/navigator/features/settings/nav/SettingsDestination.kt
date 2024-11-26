package ru.popkov.navigator.features.settings.nav

import ru.popkov.android.core.feature.nav.Destination
import ru.popkov.android.core.feature.nav.DestinationDefinition

object SettingsDestination : Destination,
    DestinationDefinition(
        route = "settings",
    )