package ru.popkov.navigator.features.auth.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ru.popkov.android.core.feature.ui.UiModePreviews
import ru.popkov.navigator.features.auth.ui.R
import ru.popkov.navigator.theme.FormularMedium14
import ru.popkov.navigator.theme.NavigatorTheme

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    keyboardActions: KeyboardActions = KeyboardActions(),
    inputFieldTextColor: Color = MaterialTheme.colorScheme.onPrimary,
    inputFieldColor: Color = MaterialTheme.colorScheme.primaryContainer,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
    @StringRes placeHolderText: Int = R.string.auth_email,
    mask: String? = null,
    maskNumber: Char? = null,
    onValueChanged: (String) -> Unit = {},
    trailingIcon: @Composable () -> Unit = {},
) {
    Column(
        modifier = modifier,
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = keyboardOptions,
            value = value,
            keyboardActions = keyboardActions,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = inputFieldColor,
                unfocusedContainerColor = inputFieldColor,
                disabledContainerColor = inputFieldColor,
                focusedTextColor = inputFieldTextColor,
                unfocusedTextColor = inputFieldTextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                disabledTextColor = Color.Transparent,
                cursorColor = inputFieldTextColor,
            ),
            visualTransformation = VisualTransformation.None,
            onValueChange = { value ->
                if (mask != null) {
                    onValueChanged(value.take(mask.count { it == maskNumber }))
                } else {
                    onValueChanged(value)
                }
            },
            shape = RoundedCornerShape(size = 16.dp),
            singleLine = true,
            placeholder = {
                Text(
                    text = stringResource(id = placeHolderText),
                    style = FormularMedium14,
                    color = inputFieldTextColor
                )
            },
            trailingIcon = trailingIcon,
            textStyle = FormularMedium14,
        )
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    NavigatorTheme {
        CustomTextField()
    }
}