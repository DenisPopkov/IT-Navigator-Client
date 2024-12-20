// Code generated by Auto Dagger. Do not edit.
package ru.popkov.navigator.features.splash.ui

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.codegen.OriginatingElement
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import ru.popkov.android.core.feature.ui.NavEntryPointProvider

@Module
@InstallIn(SingletonComponent::class)
@OriginatingElement(topLevelClass = SplashNavProvider::class)
public abstract class AutoBindSplashNavProviderSingletonModule private constructor() {
  @Binds
  @IntoSet
  public abstract
      fun bindSplashNavProviderAsNavEntryPointProviderIntoSet(splashNavProvider: SplashNavProvider):
      NavEntryPointProvider
}
