package dev.chrsep.caniuse.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.chrsep.caniuse.db.model.Feature
import kotlinx.coroutines.flow.Flow

@Dao
interface FeatureDao {
    @Query("SELECT * FROM feature")
    fun getAll(): Flow<List<Feature>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(eras: List<Feature>): Void
}