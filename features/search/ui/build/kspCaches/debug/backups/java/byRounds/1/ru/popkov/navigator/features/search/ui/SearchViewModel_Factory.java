package ru.popkov.navigator.features.search.ui;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.navigator.features.auth.domain.repositories.FeedRepository;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class SearchViewModel_Factory implements Factory<SearchViewModel> {
  private final Provider<FeedRepository> feedRepositoryProvider;

  public SearchViewModel_Factory(Provider<FeedRepository> feedRepositoryProvider) {
    this.feedRepositoryProvider = feedRepositoryProvider;
  }

  @Override
  public SearchViewModel get() {
    return newInstance(feedRepositoryProvider.get());
  }

  public static SearchViewModel_Factory create(Provider<FeedRepository> feedRepositoryProvider) {
    return new SearchViewModel_Factory(feedRepositoryProvider);
  }

  public static SearchViewModel newInstance(FeedRepository feedRepository) {
    return new SearchViewModel(feedRepository);
  }
}
