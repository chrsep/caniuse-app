import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.viewinterop.viewModel
import dev.chrsep.caniuse.components.CaniuseRootViewModel
import dev.chrsep.caniuse.components.FeaturesList

@Composable
fun SearchFeatures() {
    val viewModel: CaniuseRootViewModel = viewModel()
    val features by viewModel.features.collectAsState(listOf())

    Column {
        FeaturesList(features = features)
    }
}
