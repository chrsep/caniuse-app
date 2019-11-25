package dev.chrsep.caniuse.network

data class CaniuseData(
    val eras: Map<String, String>,
    val agents: Map<String, Agent>,
    val statuses: Map<String, String>,
    val cats: Map<String, Array<String>>,
    val data: Map<String, FeatureData>,
    val updated: Int
)

data class Agent(
    val browser: String,
    val abbr: String,
    val prefix: String,
    val type: String,
    val usage_global: Map<String, String>,
    val versions: Array<String?>
)

data class FeatureData(
    val title: String,
    val description: String,
    val spec: String,
    val status: String,
    val links: Array<LinkResources>,
    val categories: Array<String>,
    val stats: Map<String, Map<String, String>>,
    val notes: String,
    val notes_by_num: Map<Int, String>,
    val usage_perc_y: Float,
    val usage_perc_a: Float,
    val ucprefix: Boolean,
    val parent: String,
    val keywords: String,
    val ie_id: String,
    val chrome_id: String,
    val webkit_id: String
)

data class LinkResources(
    val url: String,
    val title: String
)
