package presentation.feature.splash

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.compose.koinInject
import presentation.feature.home.HomeScreenRoute
import presentation.feature.login.LoginScreenRoute

object SplashScreenRoute : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinInject<SplashViewModel>()
        val navigator = LocalNavigator.currentOrThrow
        val state by viewModel.state.collectAsState()

        Surface {
            SplashScreen(state, viewModel::handleIntent) {
                state.user?.let {
                    navigator.replaceAll(HomeScreenRoute)
                } ?: navigator.replaceAll(LoginScreenRoute)
            }
        }
    }
}
