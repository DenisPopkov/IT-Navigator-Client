package ru.popkov.navigator.features.search.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.popkov.android.core.feature.nav.Navigator
import ru.popkov.android.core.feature.ui.NavProvider
import ru.popkov.navigator.features.home.nav.HomeDestination
import ru.popkov.navigator.features.search.nav.SearchDestination
import ru.popkov.navigator.features.section.ui.SectionDestination
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class SearchNavProvider @Inject constructor(
    private val navigator: Navigator,
) : NavProvider {

    override val navBarItem = NavProvider.BottomBarItem(
        index = 1,
        labelResId = ru.popkov.navigator.features.search.nav.R.string.search_bottomnav_label,
        icon = Icons.Outlined.Search,
        route = SearchDestination.route,
        isStart = false,
    )

    override fun graph(builder: NavGraphBuilder, snackbarHostState: SnackbarHostState) =
        builder.run {
            composable(
                route = SearchDestination.route,
            ) {
                SearchScreen(
                    snackbarHostState = snackbarHostState,
                    onCardClick = {
                    },
                    onToMainClick = {
                        navigator.navigate(HomeDestination)
                    },
                    onSectionClick = {
                        navigator.navigate(SectionDestination(it))
                    }
                )
            }
        }

}