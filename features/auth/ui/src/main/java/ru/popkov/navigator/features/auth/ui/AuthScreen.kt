package ru.popkov.navigator.features.auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.popkov.android.core.feature.ui.UiModePreviews
import ru.popkov.navigator.features.auth.ui.components.EmailField
import ru.popkov.navigator.features.auth.ui.components.PasswordField
import ru.popkov.navigator.theme.FormularRegular14
import ru.popkov.navigator.theme.Grotesk36
import ru.popkov.navigator.theme.NavigatorTheme

@Composable
internal fun AuthScreen(
    snackbarHostState: SnackbarHostState,
    authViewModel: AuthViewModel = hiltViewModel(),
    onAuthClick: () -> Unit,
) {

    val state by authViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        authViewModel.effects
            .collect { effect ->
                when (effect) {
                    is AuthViewEffect.ShowError ->
                        snackbarHostState.showSnackbar(effect.errorMessage)

                    AuthViewEffect.GoToMainScreen -> onAuthClick.invoke()
                }
            }
    }

    Auth(
        state = state,
        onEmailDone = authViewModel::onAction,
        onPasswordDone = authViewModel::onAction,
        onCaptionClick = authViewModel::onAction,
        onActionDone = authViewModel::onAction,
    )
}

@Composable
private fun Auth(
    state: AuthFormState,
    onEmailDone: (AuthViewAction) -> Unit = {},
    onPasswordDone: (AuthViewAction) -> Unit = {},
    onCaptionClick: (AuthViewAction) -> Unit = {},
    onActionDone: (AuthViewAction) -> Unit = {},
) {
    val titleText = when (state.authGlobalState) {
        AuthGlobalState.REGISTER_NEW_USER_EMAIL, AuthGlobalState.REGISTER_NEW_USER_PASSWORD -> R.string.sign_title
        AuthGlobalState.AUTH -> R.string.auth_title
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.TopStart,
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .align(alignment = Alignment.End),
                painter = painterResource(id = R.drawable.login_screen),
                contentDescription = "",
            )

            Text(
                modifier = Modifier
                    .padding(top = 84.dp),
                text = stringResource(id = titleText),
                style = Grotesk36,
                color = MaterialTheme.colorScheme.onSurface,
            )

            when (state.authGlobalState) {
                AuthGlobalState.REGISTER_NEW_USER_EMAIL -> {
                    EmailField(
                        modifier = Modifier.padding(top = 72.dp),
                        onEmailDone = onActionDone,
                        onEmailChange = onEmailDone,
                    )
                }

                AuthGlobalState.REGISTER_NEW_USER_PASSWORD -> {
                    PasswordField(
                        modifier = Modifier.padding(top = 72.dp),
                        onPasswordDone = onActionDone,
                        onPasswordChange = onPasswordDone,
                    )
                }

                AuthGlobalState.AUTH -> {
                    EmailField(
                        modifier = Modifier.padding(top = 72.dp),
                        onEmailDone = onActionDone,
                        onEmailChange = onEmailDone,
                    )
                    PasswordField(
                        modifier = Modifier.padding(top = 18.dp),
                        onPasswordDone = onActionDone,
                        onPasswordChange = onPasswordDone,
                    )
                }
            }

            val clickAction = when (state.authGlobalState) {
                AuthGlobalState.REGISTER_NEW_USER_EMAIL, AuthGlobalState.REGISTER_NEW_USER_PASSWORD -> AuthViewAction.OnAlreadyHaveAccountClick
                AuthGlobalState.AUTH -> AuthViewAction.OnNoAccountClick
            }

            Text(
                modifier = Modifier
                    .padding(top = 12.dp, start = 2.dp)
                    .clickable { onCaptionClick.invoke(clickAction) },
                text = stringResource(
                    id = when (state.authGlobalState) {
                        AuthGlobalState.REGISTER_NEW_USER_EMAIL, AuthGlobalState.REGISTER_NEW_USER_PASSWORD -> R.string.auth_already_have_account
                        AuthGlobalState.AUTH -> R.string.auth_no_account
                    }
                ),
                style = FormularRegular14,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    NavigatorTheme {
        Auth(
            state = AuthFormState(),
        )
    }
}
