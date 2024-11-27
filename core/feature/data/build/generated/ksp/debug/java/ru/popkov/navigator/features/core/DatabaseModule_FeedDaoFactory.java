package ru.popkov.navigator.features.core;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.navigator.features.core.data.local.AppDatabase;
import ru.popkov.navigator.features.core.data.local.daos.FeedDao;

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
public final class DatabaseModule_FeedDaoFactory implements Factory<FeedDao> {
  private final DatabaseModule module;

  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_FeedDaoFactory(DatabaseModule module,
      Provider<AppDatabase> databaseProvider) {
    this.module = module;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public FeedDao get() {
    return feedDao(module, databaseProvider.get());
  }

  public static DatabaseModule_FeedDaoFactory create(DatabaseModule module,
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_FeedDaoFactory(module, databaseProvider);
  }

  public static FeedDao feedDao(DatabaseModule instance, AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(instance.feedDao(database));
  }
}
