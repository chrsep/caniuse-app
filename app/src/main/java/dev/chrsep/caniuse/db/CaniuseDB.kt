package dev.chrsep.caniuse.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.chrsep.caniuse.model.Era

@Database(entities = [Era::class], version = 1)
abstract class CaniuseDB: RoomDatabase() {
    abstract fun eraDao(): EraDao
}