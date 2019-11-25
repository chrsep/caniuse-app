package dev.chrsep.caniuse.dagger

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dev.chrsep.caniuse.CaniuseApp
import dev.chrsep.caniuse.MainActivity
import dev.chrsep.caniuse.ui.dashboard.DashboardFragment
import io.decapos.posix.dagger.ViewModelModule
import javax.inject.Singleton

@Component(modules = [AndroidInjectionModule::class, ActivityModule::class])
@Singleton
interface AppComponent : AndroidInjector<CaniuseApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: CaniuseApp)
}

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(
        modules = [
            DatabaseModule::class,
            NetworkModule::class,
            ViewModelModule::class,
            FragmentModule::class
        ]
    )
    abstract fun contributeMainActivityInjector(): MainActivity
}

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeDashboardFragmentInjector(): DashboardFragment
}



