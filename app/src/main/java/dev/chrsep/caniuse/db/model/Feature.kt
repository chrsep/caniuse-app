package dev.chrsep.caniuse.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Feature (
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String
)
