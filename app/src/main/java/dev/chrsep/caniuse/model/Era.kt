package dev.chrsep.caniuse.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Era (
    @PrimaryKey
    val id: String,
    val detail: String
)
