package ru.popkov.navigator.features.auth.ui;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.android.core.feature.nav.Navigator;

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
public final class AuthNavProvider_Factory implements Factory<AuthNavProvider> {
  private final Provider<Navigator> navigatorProvider;

  public AuthNavProvider_Factory(Provider<Navigator> navigatorProvider) {
    this.navigatorProvider = navigatorProvider;
  }

  @Override
  public AuthNavProvider get() {
    return newInstance(navigatorProvider.get());
  }

  public static AuthNavProvider_Factory create(Provider<Navigator> navigatorProvider) {
    return new AuthNavProvider_Factory(navigatorProvider);
  }

  public static AuthNavProvider newInstance(Navigator navigator) {
    return new AuthNavProvider(navigator);
  }
}
