package ru.popkov.navigator.features.home.ui;

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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<FeedRepository> feedRepositoryProvider;

  public HomeViewModel_Factory(Provider<FeedRepository> feedRepositoryProvider) {
    this.feedRepositoryProvider = feedRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(feedRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<FeedRepository> feedRepositoryProvider) {
    return new HomeViewModel_Factory(feedRepositoryProvider);
  }

  public static HomeViewModel newInstance(FeedRepository feedRepository) {
    return new HomeViewModel(feedRepository);
  }
}
