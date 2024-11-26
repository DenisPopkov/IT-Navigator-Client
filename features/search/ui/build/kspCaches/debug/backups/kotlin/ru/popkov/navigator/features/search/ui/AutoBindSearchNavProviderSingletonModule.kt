// Code generated by Auto Dagger. Do not edit.
package ru.popkov.navigator.features.search.ui

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.codegen.OriginatingElement
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import ru.popkov.android.core.feature.ui.NavProvider

@Module
@InstallIn(SingletonComponent::class)
@OriginatingElement(topLevelClass = SearchNavProvider::class)
public abstract class AutoBindSearchNavProviderSingletonModule private constructor() {
  @Binds
  @IntoSet
  public abstract
      fun bindSearchNavProviderAsNavProviderIntoSet(searchNavProvider: SearchNavProvider):
      NavProvider
}