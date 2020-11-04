package dev.chrsep.caniuse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.setContent
import dagger.hilt.android.AndroidEntryPoint
import dev.chrsep.caniuse.components.CaniuseRoot

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CaniuseRoot()
        }
    }
}

