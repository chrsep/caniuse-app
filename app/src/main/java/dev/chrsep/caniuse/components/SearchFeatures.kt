package dev.chrsep.caniuse.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.chrsep.caniuse.db.model.Feature
import kotlinx.coroutines.flow.Flow

@Composable
fun SearchFeatures(features: Flow<List<Feature>>) {
    val f by features.collectAsState(listOf())
    FeaturesList(features = f)
}

@Composable
fun FeaturesList(features: List<Feature>) {
    LazyColumnFor(
        items = features,
    ) {
        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = it.title)
            }
        }
    }
}
