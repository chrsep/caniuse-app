package dev.chrsep.caniuse.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.viewModel
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.ui.tooling.preview.Preview
import dev.chrsep.caniuse.repositories.CaniuseRepository


class CaniuseRootViewModel @ViewModelInject constructor(caniuseRepo: CaniuseRepository) :
    ViewModel() {
    val text = "asdf"

    val eras = caniuseRepo.getEras
}

@Composable
fun CaniuseRoot() {
    val viewModel: CaniuseRootViewModel = viewModel()
    val eras by viewModel.eras.collectAsState(listOf())

    MaterialTheme {
        Scaffold {
            Greeting(viewModel.text)
            LazyColumnFor(items = eras) {
                Text(text = it.detail)
            }
        }
    }
}

@Preview
@Composable
fun CaniusePreview() {
    CaniuseRoot()
}

@Composable
fun Greeting(name: String) {
    Card(backgroundColor = Color.White) {
        Text(text = "Hello $name!")
    }
}

