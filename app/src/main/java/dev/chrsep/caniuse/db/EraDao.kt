package dev.chrsep.caniuse.db

import androidx.room.Dao
import androidx.room.Query
import dev.chrsep.caniuse.model.Era

@Dao
interface EraDao {
    @Query("SELECT * FROM era")
    fun getAll(): List<Era>
}