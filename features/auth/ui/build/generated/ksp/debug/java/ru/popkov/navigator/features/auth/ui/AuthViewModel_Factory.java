package ru.popkov.navigator.features.auth.ui;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.popkov.navigator.features.auth.domain.repositories.AuthRepository;
import ru.popkov.navigator.features.auth.domain.usecase.ValidateEmail;
import ru.popkov.navigator.features.auth.domain.usecase.ValidatePassword;

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
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<ValidateEmail> validateEmailProvider;

  private final Provider<ValidatePassword> validatePasswordProvider;

  public AuthViewModel_Factory(Provider<AuthRepository> authRepositoryProvider,
      Provider<ValidateEmail> validateEmailProvider,
      Provider<ValidatePassword> validatePasswordProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.validateEmailProvider = validateEmailProvider;
    this.validatePasswordProvider = validatePasswordProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(authRepositoryProvider.get(), validateEmailProvider.get(), validatePasswordProvider.get());
  }

  public static AuthViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider,
      Provider<ValidateEmail> validateEmailProvider,
      Provider<ValidatePassword> validatePasswordProvider) {
    return new AuthViewModel_Factory(authRepositoryProvider, validateEmailProvider, validatePasswordProvider);
  }

  public static AuthViewModel newInstance(AuthRepository authRepository,
      ValidateEmail validateEmail, ValidatePassword validatePassword) {
    return new AuthViewModel(authRepository, validateEmail, validatePassword);
  }
}
