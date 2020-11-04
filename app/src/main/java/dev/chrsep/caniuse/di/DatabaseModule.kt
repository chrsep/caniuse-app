package dev.chrsep.caniuse.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.chrsep.caniuse.db.CaniuseDB
import dev.chrsep.caniuse.db.EraDao

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {
    /**
     * Provides DB instance.
     */
    @Provides
    fun provideDb(app: Application): CaniuseDB = Room
        .databaseBuilder(app, CaniuseDB::class.java, "caniuse.db")
        .build()

    @Provides
    fun provideEraDao(db: CaniuseDB): EraDao =
        db.eraDao()
}