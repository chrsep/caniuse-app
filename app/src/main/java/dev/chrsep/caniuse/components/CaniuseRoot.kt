package dev.chrsep.caniuse.components

import androidx.compose.foundation.Text
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.viewModel
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.ui.tooling.preview.Preview
import dev.chrsep.caniuse.db.EraDao


class CaniuseRootViewModel @ViewModelInject constructor(eraDao: EraDao) : ViewModel() {
    val text = "asdf"
}

@Composable
fun CaniuseRoot() {
    val viewModel: CaniuseRootViewModel = viewModel()

    MaterialTheme {
        Scaffold {
            Greeting(viewModel.text)
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

