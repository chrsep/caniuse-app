package dev.chrsep.caniuse.dagger

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dev.chrsep.caniuse.CaniuseAppDebug
import io.decapos.posix.dagger.ViewModelModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        DatabaseModule::class,
        NetworkModuleDebug::class,
        ViewModelModule::class,
        FragmentModule::class
    ]
)
@Singleton
interface AppComponentDebug : AndroidInjector<CaniuseAppDebug> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponentDebug
    }

    override fun inject(app: CaniuseAppDebug)
}

