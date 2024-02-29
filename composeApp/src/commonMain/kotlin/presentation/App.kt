package presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import di.initKoin
import presentation.feature.splash.SplashScreen

@Composable
fun App() {
    initKoin()
    MaterialTheme {
        Navigator(SplashScreen) { SlideTransition(it) }
    }
}
