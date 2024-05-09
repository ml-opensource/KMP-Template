package presentation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import presentation.feature.splash.SplashScreenRoute
import presentation.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        Navigator(SplashScreenRoute) { SlideTransition(it) }
    }
}
