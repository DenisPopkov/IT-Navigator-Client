package ru.popkov.navigator.features.auth.nav

import ru.popkov.android.core.feature.nav.Destination
import ru.popkov.android.core.feature.nav.DestinationDefinition

object AuthDestination : Destination,
    DestinationDefinition(
        route = "auth",
    )