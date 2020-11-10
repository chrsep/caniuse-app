package dev.chrsep.caniuse.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.viewinterop.viewModel
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.ui.tooling.preview.Preview
import dev.chrsep.caniuse.db.model.Feature
import dev.chrsep.caniuse.repositories.CaniuseRepository
import kotlinx.coroutines.launch

class CaniuseRootViewModel @ViewModelInject constructor(private val repo: CaniuseRepository) :
    ViewModel() {

    val eras = repo.eras
    val features = repo.features

    fun refreshData() = viewModelScope.launch {
        repo.refreshData()
    }
}

@Composable
fun CaniuseRoot() {
    val viewModel: CaniuseRootViewModel = viewModel()
    val features by viewModel.features.collectAsState(listOf())

    CaniuseTheme {
        Scaffold {
            Button(onClick = { viewModel.refreshData() }) {
                Text(text = "Get Data")
            }
            FeaturesList(features = features)
            LazyColumnFor(items = features) {
                Text(text = it.title)
            }
        }
    }
}

@Composable
fun FeaturesList(features: List<Feature>) {
    LazyColumnFor(items = features) {
        Text(text = it.title)
    }
}

@Preview
@Composable
fun CaniusePreview() {
    CaniuseRoot()
}
