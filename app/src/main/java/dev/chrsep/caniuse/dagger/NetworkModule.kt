package dev.chrsep.caniuse.dagger

import dagger.Module
import dagger.Provides
import dev.chrsep.caniuse.network.CaniuseService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
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
