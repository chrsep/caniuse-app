package dev.chrsep.caniuse.model

import androidx.room.Embedded
import androidx.room.Entity

@Entity
data class BrowserDetails(
    val name: String,
    val abbr: String,
    val prefix: String,
    val type: String
)


@Entity(primaryKeys = ["versionName", "agentName"])
data class BrowserVersion(
    val versionName: Int,
    val agentName: String
)

data class BrowserGlobalUsage(
    val browserVersion: String
)

data class BrowserAgent(
    @Embedded
    val details: BrowserDetails
)