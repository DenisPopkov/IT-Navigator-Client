package ru.popkov.navigator.features.core;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.datastore.token.Token;
import ru.popkov.navigator.features.auth.data.AuthInterceptor;

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
public final class NetworkModule_ProvideAuthInterceptorFactory implements Factory<AuthInterceptor> {
  private final NetworkModule module;

  private final Provider<Token> tokenProvider;

  public NetworkModule_ProvideAuthInterceptorFactory(NetworkModule module,
      Provider<Token> tokenProvider) {
    this.module = module;
    this.tokenProvider = tokenProvider;
  }

  @Override
  public AuthInterceptor get() {
    return provideAuthInterceptor(module, tokenProvider.get());
  }

  public static NetworkModule_ProvideAuthInterceptorFactory create(NetworkModule module,
      Provider<Token> tokenProvider) {
    return new NetworkModule_ProvideAuthInterceptorFactory(module, tokenProvider);
  }

  public static AuthInterceptor provideAuthInterceptor(NetworkModule instance, Token token) {
    return Preconditions.checkNotNullFromProvides(instance.provideAuthInterceptor(token));
  }
}
