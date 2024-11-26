package ru.popkov.navigator.features.settings.ui;

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
public final class SettingsNavProvider_Factory implements Factory<SettingsNavProvider> {
  private final Provider<Navigator> navigatorProvider;

  public SettingsNavProvider_Factory(Provider<Navigator> navigatorProvider) {
    this.navigatorProvider = navigatorProvider;
  }

  @Override
  public SettingsNavProvider get() {
    return newInstance(navigatorProvider.get());
  }

  public static SettingsNavProvider_Factory create(Provider<Navigator> navigatorProvider) {
    return new SettingsNavProvider_Factory(navigatorProvider);
  }

  public static SettingsNavProvider newInstance(Navigator navigator) {
    return new SettingsNavProvider(navigator);
  }
}
