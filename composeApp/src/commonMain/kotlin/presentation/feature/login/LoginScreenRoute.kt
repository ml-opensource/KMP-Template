package presentation.feature.login

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

object LoginScreenRoute : Screen {
    @Composable
    override fun Content() {
        val viewModel = LoginViewModel()
        val navigator = LocalNavigator.currentOrThrow
        val state by viewModel.state.collectAsState()

        Surface {
            LoginScreen(navigator, state, viewModel::handleIntent)
        }
    }
}
