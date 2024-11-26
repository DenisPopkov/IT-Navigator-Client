package ru.popkov.navigator.features.home.ui;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.android.core.feature.nav.Navigator;
import ru.popkov.datastore.settings.Settings;

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
public final class HomeNavProvider_Factory implements Factory<HomeNavProvider> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<Settings> settingsStoreProvider;

  public HomeNavProvider_Factory(Provider<Navigator> navigatorProvider,
      Provider<Settings> settingsStoreProvider) {
    this.navigatorProvider = navigatorProvider;
    this.settingsStoreProvider = settingsStoreProvider;
  }

  @Override
  public HomeNavProvider get() {
    return newInstance(navigatorProvider.get(), settingsStoreProvider.get());
  }

  public static HomeNavProvider_Factory create(Provider<Navigator> navigatorProvider,
      Provider<Settings> settingsStoreProvider) {
    return new HomeNavProvider_Factory(navigatorProvider, settingsStoreProvider);
  }

  public static HomeNavProvider newInstance(Navigator navigator, Settings settingsStore) {
    return new HomeNavProvider(navigator, settingsStore);
  }
}
