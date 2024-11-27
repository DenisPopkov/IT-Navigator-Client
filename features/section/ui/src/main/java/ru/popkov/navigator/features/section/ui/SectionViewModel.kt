package ru.popkov.navigator.features.section.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.popkov.android.core.feature.components.core.models.SectionType
import ru.popkov.android.core.feature.ui.EffectsDelegate
import ru.popkov.android.core.feature.ui.EffectsProvider
import ru.popkov.android.core.feature.ui.StateDelegate
import ru.popkov.android.core.feature.ui.StateProvider
import ru.popkov.navigator.features.auth.domain.model.Article
import ru.popkov.navigator.features.auth.domain.model.Company
import ru.popkov.navigator.features.auth.domain.model.Course
import ru.popkov.navigator.features.auth.domain.repositories.FeedRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SectionViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val feedRepository: FeedRepository
) : ViewModel(),
    StateProvider<SectionState> by StateDelegate(SectionState()),
    EffectsProvider<SectionViewEffect> by EffectsDelegate() {

    private val sectionId = SectionDestination.Args(savedStateHandle).sectionType
    val sectionType = SectionType.entries[(sectionId ?: 0) + 1]

    fun mockCompanies() = listOf(
        Company(
            id = 0,
            name = "7bits",
            image = "https://iili.io/2cWKYTx.md.png"
        ),
        Company(
            id = 1,
            name = "Deeplay",
            image = "https://iili.io/2cWK6uf.md.png"
        ),
        Company(
            id = 2,
            name = "Live Typing",
            image = "https://iili.io/2cvaHVs.png"
        ),
        Company(
            id = 3,
            name = "Effective",
            image = "https://iili.io/2cWBxBp.png"
        )
    )

    fun mockFeed() = listOf(
        Article(
            id = 0,
            name = "Омская область установила рекорд по участию в «Цифровом диктанте»",
            description = "Омская область установила рекорд по участию в «Цифровом диктанте»",
            image = "https://iili.io/2cVyc92.md.png"
        ),
        Article(
            id = 1,
            name = "Омские айтишники приняли участие в «Мама, папа, я — ИТ-семья»",
            description = "Омская область установила рекорд по участию в «Цифровом диктанте»",
            image = "https://iili.io/2cW2NQS.md.png"
        ),
    )

    fun mockCourses() = listOf(
        Course(
            id = 0,
            name = "Омская IT-академия",
            image = "https://iili.io/2cW3OAv.md.png"
        ),
        Course(
            id = 1,
            name = "KIBERone Омск",
            image = "https://iili.io/2cWFn0F.md.png"
        ),
    )

    fun onAction(action: SectionViewAction) {
        when (action) {
            is SectionViewAction.OnBackClick -> {
                viewModelScope.launch {
                    sendEffect(SectionViewEffect.OnBackClick)
                }
            }

            is SectionViewAction.OnCardClick -> {
                viewModelScope.launch {
                    sendEffect(SectionViewEffect.OnCardClick(action.cardId))
                }
            }

            else -> {}
        }
    }

    suspend fun getCompanies() {
        val handler = CoroutineExceptionHandler { _, throwable ->
            Timber.tag("Section:").d(throwable, "error occurred: %s", 0)
        }

        viewModelScope.launch(handler) {
            updateState { copy(isLoading = true) }
            val authors = feedRepository.getAuthorsFromLocal()
            updateState {
                copy(
                    authors = mockCompanies(),
                    articles = null,
                    courses = null,
                    isLoading = false,
                )
            }
        }.invokeOnCompletion {
            viewModelScope.launch {
                if (it != null) {
                    updateState { copy(isLoading = false) }
                    updateState {
                        copy(
                            authors = mockCompanies(),
                            articles = null,
                            courses = null,
                            isLoading = false,
                        )
                    }
//                    sendEffect(SectionViewEffect.ShowError("Произошла ошибка!"))
                }
            }
        }
    }

    suspend fun getArticles() {
        val handler = CoroutineExceptionHandler { _, throwable ->
            Timber.tag("Section:").d(throwable, "error occurred: %s", 0)
        }

        viewModelScope.launch(handler) {
            updateState { copy(isLoading = true) }
            val articles = feedRepository.getArticlesFromLocal()
            updateState {
                copy(
                    authors = null,
                    articles = mockFeed(),
                    courses = null,
                    isLoading = false,
                )
            }
        }.invokeOnCompletion {
            viewModelScope.launch {
                if (it != null) {
                    updateState { copy(isLoading = false) }
//                    sendEffect(SectionViewEffect.ShowError("Произошла ошибка!"))
                    updateState {
                        copy(
                            authors = null,
                            articles = mockFeed(),
                            courses = null,
                            isLoading = false,
                        )
                    }
                }
            }
        }
    }

    suspend fun getCourses() {
        val handler = CoroutineExceptionHandler { _, throwable ->
            Timber.tag("Section:").d(throwable, "error occurred: %s", 0)
        }

        viewModelScope.launch(handler) {
            updateState { copy(isLoading = true) }
            val courses = feedRepository.getPoetsFromLocal()
            updateState {
                copy(
                    authors = null,
                    articles = null,
                    courses = mockCourses(),
                    isLoading = false,
                )
            }
        }.invokeOnCompletion {
            viewModelScope.launch {
                if (it != null) {
                    updateState { copy(isLoading = false) }
//                    sendEffect(SectionViewEffect.ShowError("Произошла ошибка!"))
                    updateState {
                        copy(
                            authors = null,
                            articles = null,
                            courses = mockCourses(),
                            isLoading = false,
                        )
                    }
                }
            }
        }
    }
}