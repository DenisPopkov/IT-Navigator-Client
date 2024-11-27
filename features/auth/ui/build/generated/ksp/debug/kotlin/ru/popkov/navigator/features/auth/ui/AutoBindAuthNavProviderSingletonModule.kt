// Code generated by Auto Dagger. Do not edit.
package ru.popkov.navigator.features.auth.ui

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.codegen.OriginatingElement
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import ru.popkov.android.core.feature.ui.NavEntryPointProvider

@Module
@InstallIn(SingletonComponent::class)
@OriginatingElement(topLevelClass = AuthNavProvider::class)
public abstract class AutoBindAuthNavProviderSingletonModule private constructor() {
  @Binds
  @IntoSet
  public abstract
      fun bindAuthNavProviderAsNavEntryPointProviderIntoSet(authNavProvider: AuthNavProvider):
      NavEntryPointProvider
}