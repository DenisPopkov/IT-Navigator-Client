package ru.popkov.navigator.features.settings.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import ru.popkov.android.core.feature.ui.UiModePreviews
import ru.popkov.navigator.theme.FormularMedium14
import ru.popkov.navigator.theme.FormularMedium28
import ru.popkov.navigator.theme.Grotesk36
import ru.popkov.navigator.theme.NavigatorTheme

@Composable
internal fun SettingsScreen(
    snackbarHostState: SnackbarHostState,
    settingsViewModel: SettingsViewModel = hiltViewModel(),
    onDeleteAccountClick: () -> Unit = {},
    onExitAccountClick: () -> Unit = {},
) {
    val state by settingsViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        settingsViewModel.getSettings()
        settingsViewModel.effects
            .collect { effect ->
                when (effect) {
                    is SettingsViewEffect.ShowError ->
                        snackbarHostState.showSnackbar(effect.errorMessage)

                    SettingsViewEffect.OnDeleteAccountClick -> onDeleteAccountClick.invoke()
                    SettingsViewEffect.OnExitAccountClick -> onExitAccountClick.invoke()
                }
            }
    }

    Box(
        contentAlignment = Alignment.Center,
    ) {
        Settings(
            state = state,
            onAction = settingsViewModel::onAction,
        )

        AnimatedVisibility(visible = state.isLoading) {
            CircularProgressIndicator(color = Color.LightGray)
        }
    }
}

@Composable
internal fun Settings(
    modifier: Modifier = Modifier,
    state: SettingsState,
    onAction: (SettingsViewAction) -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .scrollable(orientation = Orientation.Vertical, state = rememberScrollState())
            .padding(vertical = 30.dp)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(id = R.string.settings_title),
            style = Grotesk36,
            color = MaterialTheme.colorScheme.onSurface,
        )
        AsyncImage(
            modifier = Modifier
                .padding(top = 44.dp)
                .size(size = 160.dp)
                .clip(shape = CircleShape)
                .align(Alignment.CenterHorizontally),
            fallback = painterResource(id = R.drawable.ic_placeholder),
            model = state.userImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Text(
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally),
            text = state.userName.split(" ").joinToString("\n"),
            style = FormularMedium28,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            modifier = Modifier
                .padding(top = 40.dp),
            text = stringResource(id = R.string.settings_description),
            style = FormularMedium14,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            shape = RoundedCornerShape(size = 8.dp),
            onClick = {
                onAction.invoke(SettingsViewAction.OnChangeModeClick)
            }
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                text = stringResource(id = R.string.settings_change_theme),
                style = FormularMedium14,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
        Text(
            modifier = Modifier
                .padding(top = 40.dp),
            text = stringResource(id = R.string.settings_profile_description),
            style = FormularMedium14,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            shape = RoundedCornerShape(size = 8.dp),
            onClick = {
                onAction.invoke(SettingsViewAction.OnExitAccountClick)
            }
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                text = stringResource(id = R.string.settings_exit_account),
                style = FormularMedium14,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            shape = RoundedCornerShape(size = 8.dp),
            onClick = {
                onAction.invoke(SettingsViewAction.OnDeleteAccountClick)
            }
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                text = stringResource(id = R.string.settings_delete_account),
                style = FormularMedium14.copy(color = Color.Red),
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}

@UiModePreviews
@Composable
private fun SettingsScreenPreview() {
    NavigatorTheme {
        Settings(
            state = SettingsState(),
        )
    }
}
