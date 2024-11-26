package ru.popkov.navigator.features.section.ui;

import androidx.lifecycle.SavedStateHandle;
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
public final class SectionViewModel_Factory implements Factory<SectionViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<FeedRepository> feedRepositoryProvider;

  public SectionViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<FeedRepository> feedRepositoryProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.feedRepositoryProvider = feedRepositoryProvider;
  }

  @Override
  public SectionViewModel get() {
    return newInstance(savedStateHandleProvider.get(), feedRepositoryProvider.get());
  }

  public static SectionViewModel_Factory create(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<FeedRepository> feedRepositoryProvider) {
    return new SectionViewModel_Factory(savedStateHandleProvider, feedRepositoryProvider);
  }

  public static SectionViewModel newInstance(SavedStateHandle savedStateHandle,
      FeedRepository feedRepository) {
    return new SectionViewModel(savedStateHandle, feedRepository);
  }
}
