package ru.popkov.android.core.feature.components.core.card

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.popkov.android.core.feature.ui.UiModePreviews
import ru.popkov.navigator.theme.FormularMedium14
import ru.popkov.navigator.theme.FormularRegular14
import ru.popkov.navigator.theme.NavigatorTheme

@Composable
fun Card(
    cardImageUrl: String,
    cardText: String,
    cardType: CardType = CardType.SMALL,
    isFave: Boolean = false,
    onCardActionClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .width(width = cardType.width),
    ) {
        Box(
            modifier = Modifier
                .size(height = cardType.height, width = cardType.width)
                .clip(shape = RoundedCornerShape(size = 10.dp))
                .clickable { onCardActionClick.invoke() },
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                model = cardImageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = if (cardType == CardType.LARGE) 16.dp else 10.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                AnimatedVisibility(visible = cardType == CardType.LARGE) {
                    Text(
                        text = cardText,
                        style = FormularMedium14,
                        color = Color.White,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }

        AnimatedVisibility(visible = cardType != CardType.LARGE) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                text = cardText.split("\n").joinToString(),
                style = FormularRegular14,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@Preview
@Composable
private fun SmallCardPreview() {
    NavigatorTheme {
        Card(
            cardImageUrl = "",
            cardText = "Фёдор\nДостоевский",
            cardType = CardType.SMALL,
        )
    }
}

@Preview
@Composable
private fun MediumCardPreview() {
    NavigatorTheme {
        Card(
            cardImageUrl = "",
            cardText = "Фёдор\nДостоевский",
            cardType = CardType.MEDIUM,
        )
    }
}

@UiModePreviews
@Composable
private fun LargeCardPreview() {
    NavigatorTheme {
        Card(
            cardImageUrl = "",
            cardText = "Как Толстой Войну и мир писал",
            cardType = CardType.LARGE,
            isFave = true,
        )
    }
}