package io.decapos.posix.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.chrsep.caniuse.CaniuseViewModelFactory
import dev.chrsep.caniuse.ui.dashboard.DashboardViewModel

/**
 * Provides all of the ViewModel.
 *
 * As more viewModels are created it will be added here with @IntoMap annotation.
 * so that it will be provided to PosixViewModelFactory and be used in the fragments and activities.
 */
@Suppress("unused", "TooManyFunctions")
@Module
interface ViewModelModule {
    // IntoMap is a Dagger 2 multi-binding feature, for adding items into a Map.
    // See: https://google.github.io/dagger/multibindings
    /**
     * Provides SignInViewModel for usage in PosixViewModelFactory.
     */
    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    fun bindMonthlyBreakdownViewModel(viewModel: DashboardViewModel): ViewModel

    /**
     * Provides ViewModel Factory.
     */
    @Binds
    fun bindViewModelFactory(factory: CaniuseViewModelFactory): ViewModelProvider.Factory
}
