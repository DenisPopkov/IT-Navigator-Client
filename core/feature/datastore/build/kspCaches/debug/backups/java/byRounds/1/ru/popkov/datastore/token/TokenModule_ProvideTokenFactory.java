package ru.popkov.datastore.token;

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
public final class TokenModule_ProvideTokenFactory implements Factory<Token> {
  private final TokenModule module;

  private final Provider<Context> contextProvider;

  public TokenModule_ProvideTokenFactory(TokenModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public Token get() {
    return provideToken(module, contextProvider.get());
  }

  public static TokenModule_ProvideTokenFactory create(TokenModule module,
      Provider<Context> contextProvider) {
    return new TokenModule_ProvideTokenFactory(module, contextProvider);
  }

  public static Token provideToken(TokenModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideToken(context));
  }
}
