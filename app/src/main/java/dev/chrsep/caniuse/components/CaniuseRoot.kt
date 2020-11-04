package dev.chrsep.caniuse.components

import androidx.compose.foundation.Text
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CaniuseRoot() {
    MaterialTheme {
        Scaffold {
            Greeting("Android")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Card(backgroundColor = Color.White) {
        Text(text = "Hello $name!")
    }
}

