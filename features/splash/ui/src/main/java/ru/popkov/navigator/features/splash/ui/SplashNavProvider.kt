package ru.popkov.navigator.features.splash.ui

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.popkov.android.core.feature.nav.Navigator
import ru.popkov.android.core.feature.ui.NavEntryPointProvider
import ru.popkov.datastore.token.Token
import ru.popkov.navigator.features.auth.nav.AuthDestination
import ru.popkov.navigator.features.home.nav.HomeDestination
import ru.popkov.navigator.features.splash.nav.SplashDestination
import ru.popkov.navigator.theme.NavigatorThemeInfinite
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class SplashNavProvider @Inject constructor(
    private val navigator: Navigator,
    private val dataStore: Token,
) : NavEntryPointProvider {

    override val routeItem = NavEntryPointProvider.RouteItem(
        route = SplashDestination.route,
        isStart = true,
    )

    override fun graph(builder: NavGraphBuilder, snackbarHostState: SnackbarHostState) =
        builder.run {
            composable(
                route = SplashDestination.route,
            ) {
                NavigatorThemeInfinite {
                    SplashScreen(
                        dataStore = dataStore,
                        onDelayHandle = { isShouldAuth ->
                            if (isShouldAuth) {
                                navigator.navigate(AuthDestination) {
                                    launchSingleTop = true
                                    popUpTo(0)
                                }
                            } else {
                                navigator.navigate(HomeDestination) {
                                    launchSingleTop = true
                                    popUpTo(0)
                                }
                            }
                        },
                    )
                }
            }
        }

}