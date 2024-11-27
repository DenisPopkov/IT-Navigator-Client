package ru.popkov.navigator.features.core.data.repositories;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.datastore.token.Token;
import ru.popkov.navigator.features.core.data.remote.api.SettingsApi;

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
public final class SettingsRepository_Factory implements Factory<SettingsRepository> {
  private final Provider<SettingsApi> settingsApiProvider;

  private final Provider<Token> tokenDataStoreProvider;

  public SettingsRepository_Factory(Provider<SettingsApi> settingsApiProvider,
      Provider<Token> tokenDataStoreProvider) {
    this.settingsApiProvider = settingsApiProvider;
    this.tokenDataStoreProvider = tokenDataStoreProvider;
  }

  @Override
  public SettingsRepository get() {
    return newInstance(settingsApiProvider.get(), tokenDataStoreProvider.get());
  }

  public static SettingsRepository_Factory create(Provider<SettingsApi> settingsApiProvider,
      Provider<Token> tokenDataStoreProvider) {
    return new SettingsRepository_Factory(settingsApiProvider, tokenDataStoreProvider);
  }

  public static SettingsRepository newInstance(SettingsApi settingsApi, Token tokenDataStore) {
    return new SettingsRepository(settingsApi, tokenDataStore);
  }
}
