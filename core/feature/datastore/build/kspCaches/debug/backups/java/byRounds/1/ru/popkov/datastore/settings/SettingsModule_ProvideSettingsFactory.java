package ru.popkov.datastore.settings;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class SettingsModule_ProvideSettingsFactory implements Factory<Settings> {
  private final SettingsModule module;

  private final Provider<Context> contextProvider;

  public SettingsModule_ProvideSettingsFactory(SettingsModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public Settings get() {
    return provideSettings(module, contextProvider.get());
  }

  public static SettingsModule_ProvideSettingsFactory create(SettingsModule module,
      Provider<Context> contextProvider) {
    return new SettingsModule_ProvideSettingsFactory(module, contextProvider);
  }

  public static Settings provideSettings(SettingsModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideSettings(context));
  }
}
