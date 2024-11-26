package ru.popkov.navigator.features.settings.ui;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.datastore.settings.Settings;
import ru.popkov.datastore.token.Token;
import ru.popkov.navigator.features.auth.domain.repositories.SettingsRepository;

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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<SettingsRepository> settingsRepositoryProvider;

  private final Provider<Token> tokenDatastoreProvider;

  private final Provider<Settings> settingsDatastoreProvider;

  public SettingsViewModel_Factory(Provider<SettingsRepository> settingsRepositoryProvider,
      Provider<Token> tokenDatastoreProvider, Provider<Settings> settingsDatastoreProvider) {
    this.settingsRepositoryProvider = settingsRepositoryProvider;
    this.tokenDatastoreProvider = tokenDatastoreProvider;
    this.settingsDatastoreProvider = settingsDatastoreProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(settingsRepositoryProvider.get(), tokenDatastoreProvider.get(), settingsDatastoreProvider.get());
  }

  public static SettingsViewModel_Factory create(
      Provider<SettingsRepository> settingsRepositoryProvider,
      Provider<Token> tokenDatastoreProvider, Provider<Settings> settingsDatastoreProvider) {
    return new SettingsViewModel_Factory(settingsRepositoryProvider, tokenDatastoreProvider, settingsDatastoreProvider);
  }

  public static SettingsViewModel newInstance(SettingsRepository settingsRepository,
      Token tokenDatastore, Settings settingsDatastore) {
    return new SettingsViewModel(settingsRepository, tokenDatastore, settingsDatastore);
  }
}
