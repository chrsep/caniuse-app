package dev.chrsep.caniuse.components

import SearchFeatures
import androidx.compose.foundation.Text
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

    val navController = rememberNavController()

    CaniuseTheme {
        Scaffold(
            topBar = { CaniuseTopAppBar(refresh = { viewModel.refreshData() }) }) {
            NavHost(navController, startDestination = "searchFeatures") {
                composable("searchFeatures") { SearchFeatures() }
            }
        }
    }
}

@Composable
fun CaniuseTopAppBar(refresh: () -> Unit) {
    TopAppBar(
        title = { Text("Caniuse") },
        elevation = Dp(3f),
        actions = {
            IconButton(onClick = refresh) {
                Icon(Icons.Filled.Refresh)
            }
        },
    )
}

@Composable
fun FeaturesList(features: List<Feature>) {
    LazyColumnFor(items = features) {
        Text(text = it.title)
    }
}
