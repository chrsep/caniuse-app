package dev.chrsep.caniuse.dagger

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import dagger.Module
import dagger.Provides
import dev.chrsep.caniuse.network.CaniuseService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModuleDebug() {

    @Provides
    fun provideCaniuseService(networkFlipperPlugin: NetworkFlipperPlugin): CaniuseService {
        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(FlipperOkhttpInterceptor(networkFlipperPlugin))
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Fyrd/caniuse/master/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(CaniuseService::class.java)
    }

    @Singleton
    @Provides
    fun provideNetworkFlipperPlugin() = NetworkFlipperPlugin()
}