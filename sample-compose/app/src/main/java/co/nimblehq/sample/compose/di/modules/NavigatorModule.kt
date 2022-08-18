package co.nimblehq.sample.compose.di.modules

import co.nimblehq.sample.compose.ui.screens.MainNavigator
import co.nimblehq.sample.compose.ui.screens.MainNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class NavigatorModule {

    @Binds
    abstract fun mainNavigator(mainNavigator: MainNavigatorImpl): MainNavigator
}
