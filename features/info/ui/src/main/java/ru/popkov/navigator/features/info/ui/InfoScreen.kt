package ru.popkov.navigator.features.info.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import ru.popkov.android.core.feature.components.core.SectionHeader
import ru.popkov.android.core.feature.components.core.models.SectionType

@Composable
fun InfoScreen(
    infoViewModel: InfoViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(color = MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(vertical = 30.dp)
            .padding(horizontal = 16.dp),
    ) {
        SectionDescription(
            modifier = Modifier,
            sectionType = infoViewModel.sectionType,
            onAction = {
                onBackClick.invoke()
            }
        )

        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            when (infoViewModel.sectionType) {
                SectionType.COURSE -> {
                    val data = infoViewModel.mockCourses()
                        .find { it.id.toInt() == infoViewModel.componentId }
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(200.dp),
                        model = data?.image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = data?.name ?: "",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        Text(
                            text = data?.desc ?: "",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }

                SectionType.COMPANY -> {
                    val data = infoViewModel.mockCourses()
                        .find { it.id.toInt() == infoViewModel.componentId }
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(200.dp),
                        model = data?.image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = data?.name ?: "",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        Text(
                            text = data?.desc ?: "",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }

                else -> {
                    val data = infoViewModel.mockCourses()
                        .find { it.id.toInt() == infoViewModel.componentId }
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(200.dp),
                        model = data?.image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = data?.name ?: "",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(vertical = 8.dp)
                        )

                        Text(
                            text = data?.date ?: "",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Normal
                            ),
                            modifier = Modifier.padding(vertical = 4.dp)
                        )

                        Text(
                            text = data?.desc ?: "",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
internal fun SectionDescription(
    modifier: Modifier = Modifier,
    sectionType: SectionType,
    onAction: (InfoViewAction) -> Unit = {},
) {
    SectionHeader(
        sectionText = when (sectionType) {
            SectionType.COMPANY -> R.string.title_companies
            SectionType.ARTICLE -> R.string.title_articles
            SectionType.COURSE -> R.string.title_courses
            else -> 0
        },
        onSectionClick = {
            onAction.invoke(InfoViewAction.OnBackClick)
        }
    )
}
