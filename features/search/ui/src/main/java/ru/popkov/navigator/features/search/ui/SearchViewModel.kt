package ru.popkov.navigator.features.search.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.popkov.android.core.feature.components.core.models.SectionFilterItem
import ru.popkov.android.core.feature.components.core.models.SectionType
import ru.popkov.android.core.feature.ui.EffectsDelegate
import ru.popkov.android.core.feature.ui.EffectsProvider
import ru.popkov.android.core.feature.ui.StateDelegate
import ru.popkov.android.core.feature.ui.StateProvider
import ru.popkov.navigator.features.auth.domain.repositories.FeedRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val feedRepository: FeedRepository,
) : ViewModel(),
    StateProvider<SearchState> by StateDelegate(SearchState()),
    EffectsProvider<SearchViewEffect> by EffectsDelegate() {

    fun onAction(action: SearchViewAction) {
        when (action) {

            is SearchViewAction.OnMainScreenClick -> {
                viewModelScope.launch {
                    sendEffect(SearchViewEffect.GoToMainScreen)
                }
            }

            is SearchViewAction.OnSectionItemClick -> {
                viewModelScope.launch {
                    val updatedFilter = updateFilter(action.sectionType)
                    setFilter(sectionType = action.sectionType)
                    updateState { copy(filterList = updatedFilter) }
                }
            }

            is SearchViewAction.OnSearchChange -> {
                viewModelScope.launch {
                    getAll(filter = action.searchText)
                }
            }

            is SearchViewAction.OnSectionClick -> {
                viewModelScope.launch {
                    sendEffect(SearchViewEffect.OnSectionClick(action.sectionId))
                }
            }

            is SearchViewAction.OnCardClick -> {
                viewModelScope.launch {
                    sendEffect(SearchViewEffect.OnCardClick(action.cardId))
                }
            }
        }
    }

    private fun updateFilter(sectionType: SectionType): List<SectionFilterItem> {
        val res = state.value.filterList.map {
            it.isSectionSelected = (it.sectionType == sectionType)
            it
        }
        return res
    }

    private suspend fun setFilter(sectionType: SectionType) {
        when (sectionType) {
            SectionType.ALL -> getAll()
            SectionType.COMPANY -> getAuthors()
            SectionType.ARTICLE -> getArticles()
            else -> getPoets()
        }
    }

    suspend fun getAll(filter: String? = null) {
        val handler = CoroutineExceptionHandler { _, throwable ->
            Timber.tag("Search:").d(throwable, "error occurred: %s", 0)
        }

        viewModelScope.launch(handler) {
            updateState { copy(isLoading = true) }
            val authors =
                feedRepository.getAuthorsFromLocal().filter { it.name.contains(filter ?: it.name) }
            val articles = feedRepository.getArticlesFromLocal()
                .filter { it.name.contains((filter ?: it.name)) }
            val courses =
                feedRepository.getPoetsFromLocal().filter { it.name.contains((filter ?: it.name)) }
            updateState {
                copy(
                    authors = authors,
                    articles = articles,
                    courses = courses,
                    isEmptyState = authors.isEmpty() && articles.isEmpty() && courses.isEmpty(),
                    isLoading = false,
                )
            }
        }.invokeOnCompletion {
            viewModelScope.launch {
                if (it != null) {
                    updateState { copy(isLoading = false) }
                    sendEffect(SearchViewEffect.ShowError("Произошла ошибка!"))
                }
            }
        }
    }

    private suspend fun getAuthors(filter: String? = null) {
        val handler = CoroutineExceptionHandler { _, throwable ->
            Timber.tag("Search:").d(throwable, "error occurred: %s", 0)
        }

        viewModelScope.launch(handler) {
            updateState { copy(isLoading = true) }
            val authors = feedRepository.getAuthorsFromLocal()
            updateState {
                copy(
                    authors = authors.filter { it.name.contains((filter ?: it.name)) },
                    articles = null,
                    courses = null,
                    isEmptyState = authors.isEmpty(),
                    isLoading = false,
                )
            }
        }.invokeOnCompletion {
            viewModelScope.launch {
                if (it != null) {
                    updateState { copy(isLoading = false) }
                    sendEffect(SearchViewEffect.ShowError("Произошла ошибка!"))
                }
            }
        }
    }

    private suspend fun getArticles(filter: String? = null) {
        val handler = CoroutineExceptionHandler { _, throwable ->
            Timber.tag("Search:").d(throwable, "error occurred: %s", 0)
        }

        viewModelScope.launch(handler) {
            updateState { copy(isLoading = true) }
            val articles = feedRepository.getArticlesFromLocal()
            updateState {
                copy(
                    authors = null,
                    articles = articles.filter { it.name.contains((filter ?: it.name)) },
                    courses = null,
                    isEmptyState = articles.isEmpty(),
                    isLoading = false,
                )
            }
        }.invokeOnCompletion {
            viewModelScope.launch {
                if (it != null) {
                    updateState { copy(isLoading = false) }
                    sendEffect(SearchViewEffect.ShowError("Произошла ошибка!"))
                }
            }
        }
    }

    private suspend fun getPoets(filter: String? = null) {
        val handler = CoroutineExceptionHandler { _, throwable ->
            Timber.tag("Search:").d(throwable, "error occurred: %s", 0)
        }

        viewModelScope.launch(handler) {
            updateState { copy(isLoading = true) }
            val courses = feedRepository.getPoetsFromLocal()
            updateState {
                copy(
                    authors = null,
                    articles = null,
                    courses = courses.filter { it.name.contains((filter ?: it.name)) },
                    isEmptyState = courses.isEmpty(),
                    isLoading = false,
                )
            }
        }.invokeOnCompletion {
            viewModelScope.launch {
                if (it != null) {
                    updateState { copy(isLoading = false) }
                    sendEffect(SearchViewEffect.ShowError("Произошла ошибка!"))
                }
            }
        }
    }
}