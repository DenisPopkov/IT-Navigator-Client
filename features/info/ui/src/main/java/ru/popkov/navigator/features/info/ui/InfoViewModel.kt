package ru.popkov.navigator.features.info.ui

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
import ru.popkov.navigator.features.auth.domain.repositories.FeedRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val feedRepository: FeedRepository
) : ViewModel(),
    StateProvider<InfoState> by StateDelegate(InfoState()),
    EffectsProvider<InfoViewEffect> by EffectsDelegate() {

    private val sectionId = InfoDestination.Args(savedStateHandle).sectionType
    val componentId = InfoDestination.Args(savedStateHandle).componentId
    val sectionType = SectionType.entries[(sectionId ?: 0) + 1]

    fun onAction(action: InfoViewAction) {
        when (action) {
            is InfoViewAction.OnBackClick -> {
                viewModelScope.launch {
                    sendEffect(InfoViewEffect.OnBackClick)
                }
            }

        }

        suspend fun getCompanies() {
            val handler = CoroutineExceptionHandler { _, throwable ->
                Timber.tag("Section:").d(throwable, "error occurred: %s", 0)
            }

            viewModelScope.launch(handler) {
                updateState { copy(isLoading = true) }
                val companies = feedRepository.getAuthorsFromLocal()
                updateState {
                    copy(
                        companies = companies,
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
                                companies = companies,
                                articles = null,
                                courses = null,
                                isLoading = false,
                            )
                        }
                        sendEffect(InfoViewEffect.ShowError("Произошла ошибка!"))
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
                        companies = null,
                        articles = articles,
                        courses = null,
                        isLoading = false,
                    )
                }
            }.invokeOnCompletion {
                viewModelScope.launch {
                    if (it != null) {
                        updateState { copy(isLoading = false) }
                        sendEffect(InfoViewEffect.ShowError("Произошла ошибка!"))
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
                        companies = null,
                        articles = null,
                        courses = courses,
                        isLoading = false,
                    )
                }
            }.invokeOnCompletion {
                viewModelScope.launch {
                    if (it != null) {
                        updateState { copy(isLoading = false) }
                        sendEffect(InfoViewEffect.ShowError("Произошла ошибка!"))
                    }
                }
            }
        }
    }
}