package ru.popkov.navigator.features.core.data.repositories;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.navigator.features.core.data.local.daos.FeedDao;
import ru.popkov.navigator.features.core.data.remote.api.FeedApi;

@ScopeMetadata("javax.inject.Singleton")
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
public final class FeedRepository_Factory implements Factory<FeedRepository> {
  private final Provider<FeedApi> feedApiProvider;

  private final Provider<FeedDao> feedDaoProvider;

  public FeedRepository_Factory(Provider<FeedApi> feedApiProvider,
      Provider<FeedDao> feedDaoProvider) {
    this.feedApiProvider = feedApiProvider;
    this.feedDaoProvider = feedDaoProvider;
  }

  @Override
  public FeedRepository get() {
    return newInstance(feedApiProvider.get(), feedDaoProvider.get());
  }

  public static FeedRepository_Factory create(Provider<FeedApi> feedApiProvider,
      Provider<FeedDao> feedDaoProvider) {
    return new FeedRepository_Factory(feedApiProvider, feedDaoProvider);
  }

  public static FeedRepository newInstance(FeedApi feedApi, FeedDao feedDao) {
    return new FeedRepository(feedApi, feedDao);
  }
}
