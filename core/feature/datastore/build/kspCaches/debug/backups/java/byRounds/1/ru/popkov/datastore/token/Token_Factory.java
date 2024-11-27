package ru.popkov.datastore.token;

import androidx.datastore.core.DataStore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.android.core.feature.datastore.ProtoToken;

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
public final class Token_Factory implements Factory<Token> {
  private final Provider<DataStore<ProtoToken>> tokenProvider;

  public Token_Factory(Provider<DataStore<ProtoToken>> tokenProvider) {
    this.tokenProvider = tokenProvider;
  }

  @Override
  public Token get() {
    return newInstance(tokenProvider.get());
  }

  public static Token_Factory create(Provider<DataStore<ProtoToken>> tokenProvider) {
    return new Token_Factory(tokenProvider);
  }

  public static Token newInstance(DataStore<ProtoToken> token) {
    return new Token(token);
  }
}
