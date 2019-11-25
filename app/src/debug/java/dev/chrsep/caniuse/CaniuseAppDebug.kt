package dev.chrsep.caniuse

import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.crashreporter.CrashReporterPlugin
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin
import com.facebook.soloader.SoLoader
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dev.chrsep.caniuse.dagger.DaggerAppComponentDebug

class CaniuseAppDebug : CaniuseApp() {

//    @Inject
//    lateinit var networkFlipperPlugin: NetworkFlipperPlugin

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponentDebug.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false);

        if (FlipperUtils.shouldEnableFlipper(this)) {
            val client = AndroidFlipperClient.getInstance(this);
            client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()));
            client.addPlugin(DatabasesFlipperPlugin(this));
            client.addPlugin(CrashReporterPlugin.getInstance());
            client.addPlugin(NavigationFlipperPlugin.getInstance());
//            client.addPlugin(networkFlipperPlugin);
            client.start();
        }

    }

}