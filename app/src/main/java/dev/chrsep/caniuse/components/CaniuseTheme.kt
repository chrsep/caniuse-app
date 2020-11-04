package dev.chrsep.caniuse.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun CaniuseTheme(children: @Composable () -> Unit) {
    MaterialTheme {
        children()
    }
}