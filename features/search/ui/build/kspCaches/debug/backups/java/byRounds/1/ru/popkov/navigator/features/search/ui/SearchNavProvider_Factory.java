package ru.popkov.navigator.features.search.ui;

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
public final class SearchNavProvider_Factory implements Factory<SearchNavProvider> {
  private final Provider<Navigator> navigatorProvider;

  public SearchNavProvider_Factory(Provider<Navigator> navigatorProvider) {
    this.navigatorProvider = navigatorProvider;
  }

  @Override
  public SearchNavProvider get() {
    return newInstance(navigatorProvider.get());
  }

  public static SearchNavProvider_Factory create(Provider<Navigator> navigatorProvider) {
    return new SearchNavProvider_Factory(navigatorProvider);
  }

  public static SearchNavProvider newInstance(Navigator navigator) {
    return new SearchNavProvider(navigator);
  }
}
