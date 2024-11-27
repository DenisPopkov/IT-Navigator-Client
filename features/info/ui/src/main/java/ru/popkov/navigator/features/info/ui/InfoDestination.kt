package ru.popkov.navigator.features.info.ui

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import ru.popkov.android.core.feature.nav.Destination
import ru.popkov.android.core.feature.nav.DestinationDefinition

const val infoRoute = "info"
const val sectionArg = "sectionArg"
const val itemArg = "itemArg"

data class InfoDestination(
    val sectionType: Int,
    val componentId: Int?,
) : Destination {

    companion object : DestinationDefinition(
        route = "$infoRoute?$sectionArg={$sectionArg}&$itemArg={$itemArg}",
        args = listOf(
            navArgument(sectionArg) {
                type = NavType.IntType
            },
            navArgument(itemArg) {
                type = NavType.IntType
            },
        ),
    )

    data class Args(
        val sectionType: Int?,
        val componentId: Int?,
    ) {

        constructor(savedStateHandle: SavedStateHandle) : this(
            sectionType = savedStateHandle.get<Int>(sectionArg),
            componentId = savedStateHandle.get<Int>(itemArg),
        )
    }

    override fun toString() =
        "$infoRoute?$sectionArg=$sectionType&$itemArg={$componentId}"
}
