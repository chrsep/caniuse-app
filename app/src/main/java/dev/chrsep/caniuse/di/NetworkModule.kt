package dev.chrsep.caniuse.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.chrsep.caniuse.network.CaniuseService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Provides
    fun provideCaniuseService(): CaniuseService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Fyrd/caniuse/master/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        return retrofit.create(CaniuseService::class.java)
    }
}
