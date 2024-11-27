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
import ru.popkov.navigator.features.auth.domain.repositories.FeedRepository
import timber.log.Timber
import javax.inject.Inject

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
                        companies = companies,
                        articles = articles,
                        courses = courses,
                        isLoading = false,
                    )
                }
            } else {
                val companies = feedRepository.getCompanies()
                val articles = feedRepository.getArticles()
                val courses = feedRepository.getCourses()

                updateState {
                    copy(
                        companies = companies,
                        articles = articles,
                        courses = courses,
                        isLoading = false,
                    )
                }
            }
        }.invokeOnCompletion {
            viewModelScope.launch {
                if (it != null) {
                    updateState { copy(isLoading = false) }
                    sendEffect(HomeViewEffect.ShowError("Произошла ошибка!"))
                }
            }
        }
    }
}