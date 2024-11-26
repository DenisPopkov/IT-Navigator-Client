package ru.popkov.navigator.features.home.nav

import ru.popkov.android.core.feature.nav.Destination
import ru.popkov.android.core.feature.nav.DestinationDefinition

object HomeDestination : Destination,
    DestinationDefinition(
        route = "home",
    )