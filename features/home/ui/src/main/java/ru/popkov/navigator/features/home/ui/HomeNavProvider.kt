package ru.popkov.navigator.features.home.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import ru.popkov.android.core.feature.nav.Navigator
import ru.popkov.android.core.feature.ui.NavProvider
import ru.popkov.datastore.settings.Settings
import ru.popkov.navigator.features.home.nav.HomeDestination
import ru.popkov.navigator.features.home.nav.R
import ru.popkov.navigator.features.section.ui.SectionDestination
import ru.popkov.navigator.theme.NavigatorThemeInfinite
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class HomeNavProvider @Inject constructor(
    private val navigator: Navigator,
    private val settingsStore: Settings?,
) : NavProvider {

    override val navBarItem = NavProvider.BottomBarItem(
        index = 0,
        labelResId = R.string.home_bottomnav_label,
        icon = Icons.Outlined.Home,
        route = HomeDestination.route,
        isStart = false,
    )

    override fun graph(builder: NavGraphBuilder, snackbarHostState: SnackbarHostState) =
        builder.run {
            navigation(
                startDestination = HomeDestination.route,
                route = "clipy",
            ) {
                composable(
                    route = HomeDestination.route,
                ) {
                    val mode = settingsStore?.isLightMode?.collectAsState(initial = null)
                    NavigatorThemeInfinite(
                        darkTheme = mode?.value?.isLight ?: false,
                    ) {
                        HomeScreen(
                            snackbarHostState = snackbarHostState,
                            onCardClick = {

                            },
                            onSectionClick = {
                                navigator.navigate(SectionDestination(it))
                            }
                        )
                    }
                }

            }
        }

}