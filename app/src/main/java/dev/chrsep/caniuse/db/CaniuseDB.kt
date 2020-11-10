package dev.chrsep.caniuse.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.chrsep.caniuse.db.model.Era
import dev.chrsep.caniuse.db.model.Feature

@Database(entities = [Era::class, Feature::class], version = 2)
abstract class CaniuseDB : RoomDatabase() {
    abstract fun eraDao(): EraDao
    abstract fun featureDao(): FeatureDao
}