package dev.chrsep.caniuse.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.chrsep.caniuse.model.Era
import kotlinx.coroutines.flow.Flow

@Dao
interface EraDao {
    @Query("SELECT * FROM era")
    fun getAll(): Flow<Era>

    @Insert
    suspend fun insert(eras: List<Era>): Void
}