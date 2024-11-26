package ru.popkov.navigator.features.section.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.popkov.android.core.feature.components.core.SectionHeader
import ru.popkov.android.core.feature.components.core.card.Card
import ru.popkov.android.core.feature.components.core.card.CardType
import ru.popkov.android.core.feature.components.core.models.SectionType
import ru.popkov.android.core.feature.ui.UiModePreviews
import ru.popkov.navigator.theme.NavigatorTheme

@Composable
fun SectionScreen(
    snackbarHostState: SnackbarHostState,
    sectionViewModel: SectionViewModel = hiltViewModel(),
    onCardClick: (cardId: Long) -> Unit = {},
    onBackClick: () -> Unit,
) {
    val state by sectionViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        when (sectionViewModel.sectionType) {
            SectionType.AUTHOR -> sectionViewModel.getAuthors()
            SectionType.ARTICLE -> sectionViewModel.getArticles()
            SectionType.POET -> sectionViewModel.getPoets()
            else -> {}
        }
        sectionViewModel.effects
            .collect { effect ->
                when (effect) {
                    is SectionViewEffect.OnCardClick -> onCardClick.invoke(effect.cardId)
                    is SectionViewEffect.ShowError -> snackbarHostState.showSnackbar(effect.errorMessage)
                    is SectionViewEffect.OnBackClick -> onBackClick.invoke()
                }
            }
    }

    SectionDescription(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .statusBarsPadding()
            .padding(vertical = 30.dp)
            .padding(horizontal = 16.dp),
        state = state,
        onAction = sectionViewModel::onAction,
        sectionType = sectionViewModel.sectionType,
    )
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun SectionDescription(
    modifier: Modifier = Modifier,
    state: SectionState,
    sectionType: SectionType,
    onAction: (SectionViewAction) -> Unit = {},
) {
    Column(
        modifier = modifier,
    ) {
        SectionHeader(
            sectionText = when (sectionType) {
                SectionType.AUTHOR -> R.string.title_authors
                SectionType.ARTICLE -> R.string.title_articles
                SectionType.POET -> R.string.title_poets
                else -> 0
            },
            onSectionClick = {
                onAction.invoke(SectionViewAction.OnBackClick)
            }
        )
        if (!state.authors.isNullOrEmpty()) {
            FlowRow(
                modifier = Modifier
                    .padding(top = 48.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                maxItemsInEachRow = 2,
            ) {
                state.authors.forEach { author ->
                    Card(
                        cardImageUrl = author.image,
                        cardText = author.name,
                        cardType = CardType.SECTION,
                        onCardActionClick = {
                            onAction.invoke(
                                SectionViewAction.OnCardClick(author.id)
                            )
                        },
                    )
                }
            }
        }

        if (!state.articles.isNullOrEmpty()) {
            FlowRow(
                modifier = Modifier
                    .padding(top = 48.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                maxItemsInEachRow = 2,
            ) {
                state.articles.forEach { article ->
                    Card(
                        cardImageUrl = article.image,
                        cardText = article.name,
                        cardType = CardType.SECTION,
                        onCardActionClick = {
                            onAction.invoke(
                                SectionViewAction.OnCardClick(article.id)
                            )
                        },
                    )
                }
            }
        }

        if (!state.poets.isNullOrEmpty()) {
            FlowRow(
                modifier = Modifier
                    .padding(top = 48.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                maxItemsInEachRow = 2,
            ) {
                state.poets.forEach { poet ->
                    Card(
                        cardImageUrl = poet.image,
                        cardText = poet.name,
                        cardType = CardType.SECTION,
                        onCardActionClick = {
                            onAction.invoke(
                                SectionViewAction.OnCardClick(poet.id)
                            )
                        },
                    )
                }
            }
        }
    }
}

@UiModePreviews
@Composable
private fun SectionPreview() {
    NavigatorTheme {
        SectionDescription(
            state = SectionState(),
            sectionType = SectionType.AUTHOR,
        )
    }
}