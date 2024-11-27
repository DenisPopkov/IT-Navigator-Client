package ru.popkov.navigator.features.auth.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
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
public final class AuthInterceptor_Factory implements Factory<AuthInterceptor> {
  private final Provider<Token> tokenProvider;

  public AuthInterceptor_Factory(Provider<Token> tokenProvider) {
    this.tokenProvider = tokenProvider;
  }

  @Override
  public AuthInterceptor get() {
    return newInstance(tokenProvider.get());
  }

  public static AuthInterceptor_Factory create(Provider<Token> tokenProvider) {
    return new AuthInterceptor_Factory(tokenProvider);
  }

  public static AuthInterceptor newInstance(Token token) {
    return new AuthInterceptor(token);
  }
}
