package ru.popkov.navigator.features.splash.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.delay
import ru.popkov.android.core.feature.ui.UiModePreviews
import ru.popkov.datastore.token.Token
import ru.popkov.navigator.theme.GothicBoldSplash40
import ru.popkov.navigator.theme.NavigatorThemeInfinite
import ru.popkov.navigator.theme.Theme

@Composable
internal fun SplashScreen(
    dataStore: Token? = null,
    onDelayHandle: (isAuth: Boolean) -> Unit = {},
) {

    val jwt = dataStore?.jwt?.collectAsState(initial = null)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
    ) {
        Text(
            modifier = Modifier
                .align(alignment = Alignment.BottomStart)
                .padding(bottom = Theme.size.large)
                .padding(start = Theme.size.medium),
            text = stringResource(id = R.string.splash_screen_label),
            style = GothicBoldSplash40,
            color = Color.Black,
        )
    }

    // navigate to main screen after small delay
    LaunchedEffect(Unit) {
        delay(2000)
        onDelayHandle.invoke(jwt?.value?.token.isNullOrBlank())
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    NavigatorThemeInfinite {
        SplashScreen()
    }
}