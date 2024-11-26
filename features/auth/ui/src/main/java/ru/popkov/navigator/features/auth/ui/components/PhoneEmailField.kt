package ru.popkov.navigator.features.auth.ui.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import ru.popkov.android.core.feature.ui.UiModePreviews
import ru.popkov.navigator.features.auth.ui.AuthViewAction
import ru.popkov.navigator.features.auth.ui.R
import ru.popkov.navigator.theme.NavigatorTheme

@Composable
fun EmailField(
    modifier: Modifier = Modifier,
    onEmailDone: (AuthViewAction) -> Unit = {},
    onEmailChange: (AuthViewAction) -> Unit = {},
) {
    var email by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    CustomTextField(
        modifier = modifier,
        value = email,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        keyboardActions = KeyboardActions(onDone = {
            onEmailDone.invoke(AuthViewAction.OnDone)
            keyboardController?.hide()
        }),
        placeHolderText = R.string.auth_email,
        onValueChanged = {
            email = it
            onEmailChange.invoke(AuthViewAction.OnEmailChange(email))
        },
        trailingIcon = {
            if (email.isNotEmpty()) {
                IconButton(onClick = { email = "" }) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = null,
                    )
                }
            }
        }
    )
}

@UiModePreviews
@Composable
private fun Preview() {
    NavigatorTheme {
        EmailField()
    }
}