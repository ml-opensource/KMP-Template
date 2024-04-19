package presentation.feature.home

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen

object HomeScreenRoute : Screen {

    @Composable
    override fun Content() {
        val viewModel = HomeViewModel()
        val state by viewModel.state.collectAsState()

        Surface {
            HomeScreen(state, viewModel::handleIntent)
        }
    }
}
