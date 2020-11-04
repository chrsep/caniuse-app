package dev.chrsep.caniuse.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.chrsep.caniuse.db.model.Era
import kotlinx.coroutines.flow.Flow

@Dao
interface EraDao {
    @Query("SELECT * FROM era")
    fun getAll(): Flow<Era>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(eras: List<Era>): Void
}