package ru.popkov.navigator.features.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
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
        image = "https://iili.io/2cWK6uf.md.png"
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

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val feedRepository: FeedRepository,
) : ViewModel(),
    StateProvider<HomeState> by StateDelegate(HomeState()),
    EffectsProvider<HomeViewEffect> by EffectsDelegate() {

    fun onAction(action: HomeViewAction) {
        when (action) {
            is HomeViewAction.OnSectionClick -> {
                viewModelScope.launch {
                    sendEffect(HomeViewEffect.OnSectionClick(action.sectionId))
                }
            }

            is HomeViewAction.OnCardClick -> {
                viewModelScope.launch {
                    sendEffect(HomeViewEffect.OnCardClick(action.cardId))
                }
            }

        }
    }

    suspend fun getFeed() {
        val handler = CoroutineExceptionHandler { _, throwable ->
            Timber.tag("Home:").d(throwable, "error occurred: %s", 0)
        }

        viewModelScope.launch(handler) {
            updateState { copy(isLoading = true) }
            val authorsFromLocal = feedRepository.getAuthorsFromLocal()
            val articlesFromLocal = feedRepository.getArticlesFromLocal()
            val poetsFromLocal = feedRepository.getPoetsFromLocal()

            if (authorsFromLocal.isNotEmpty() && articlesFromLocal.isNotEmpty() && poetsFromLocal.isNotEmpty()) {
                updateState {
                    copy(
                        authors = mockCompanies(),
                        articles = mockFeed(),
                        courses = mockCourses(),
                        isLoading = false,
                    )
                }
            } else {
                val authors = feedRepository.getCompanies()
                val articles = feedRepository.getArticles()
                val courses = feedRepository.getCourses()

                updateState {
                    copy(
                        authors = mockCompanies(),
                        articles = mockFeed(),
                        courses = mockCourses(),
                        isLoading = false,
                    )
                }
            }
        }.invokeOnCompletion {
            viewModelScope.launch {
                if (it != null) {
                    updateState { copy(isLoading = false) }
                    updateState {
                        copy(
                            authors = mockCompanies(),
                            articles = mockFeed(),
                            courses = mockCourses(),
                            isLoading = false,
                        )
                    }
//                    sendEffect(HomeViewEffect.ShowError("Произошла ошибка!"))
                }
            }
        }
    }
}