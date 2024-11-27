package ru.popkov.datastore.settings;

import androidx.datastore.core.DataStore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.android.core.feature.datastore.ProtoSettings;

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
public final class Settings_Factory implements Factory<Settings> {
  private final Provider<DataStore<ProtoSettings>> isLightProvider;

  public Settings_Factory(Provider<DataStore<ProtoSettings>> isLightProvider) {
    this.isLightProvider = isLightProvider;
  }

  @Override
  public Settings get() {
    return newInstance(isLightProvider.get());
  }

  public static Settings_Factory create(Provider<DataStore<ProtoSettings>> isLightProvider) {
    return new Settings_Factory(isLightProvider);
  }

  public static Settings newInstance(DataStore<ProtoSettings> isLight) {
    return new Settings(isLight);
  }
}
