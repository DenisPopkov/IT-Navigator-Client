package ru.popkov.navigator.features.auth.data.repositories;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.datastore.token.Token;

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
public final class AuthRepository_Factory implements Factory<AuthRepository> {
  private final Provider<Token> dataStoreProvider;

  public AuthRepository_Factory(Provider<Token> dataStoreProvider) {
    this.dataStoreProvider = dataStoreProvider;
  }

  @Override
  public AuthRepository get() {
    return newInstance(dataStoreProvider.get());
  }

  public static AuthRepository_Factory create(Provider<Token> dataStoreProvider) {
    return new AuthRepository_Factory(dataStoreProvider);
  }

  public static AuthRepository newInstance(Token dataStore) {
    return new AuthRepository(dataStore);
  }
}
