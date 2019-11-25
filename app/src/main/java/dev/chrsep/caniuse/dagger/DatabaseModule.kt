package dev.chrsep.caniuse.dagger

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dev.chrsep.caniuse.db.CaniuseDB
import dev.chrsep.caniuse.db.EraDao
import javax.inject.Singleton

@Module
class DatabaseModule {
    /**
     * Provides DB instance.
     */
    @Singleton
    @Provides
    fun provideDb(app: Application): CaniuseDB = Room
        .databaseBuilder(app, CaniuseDB::class.java, "caniuse.db")
        .build()

    @Singleton
    @Provides
    fun provideEraDao(db: CaniuseDB): EraDao =
        db.eraDao()
}