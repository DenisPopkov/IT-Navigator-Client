package ru.popkov.navigator.features.splash.ui;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.android.core.feature.nav.Navigator;
import ru.popkov.datastore.token.Token;

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
public final class SplashNavProvider_Factory implements Factory<SplashNavProvider> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<Token> dataStoreProvider;

  public SplashNavProvider_Factory(Provider<Navigator> navigatorProvider,
      Provider<Token> dataStoreProvider) {
    this.navigatorProvider = navigatorProvider;
    this.dataStoreProvider = dataStoreProvider;
  }

  @Override
  public SplashNavProvider get() {
    return newInstance(navigatorProvider.get(), dataStoreProvider.get());
  }

  public static SplashNavProvider_Factory create(Provider<Navigator> navigatorProvider,
      Provider<Token> dataStoreProvider) {
    return new SplashNavProvider_Factory(navigatorProvider, dataStoreProvider);
  }

  public static SplashNavProvider newInstance(Navigator navigator, Token dataStore) {
    return new SplashNavProvider(navigator, dataStore);
  }
}
