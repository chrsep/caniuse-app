package dev.chrsep.caniuse

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dev.chrsep.caniuse.dagger.DaggerAppComponent

class CaniuseApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}