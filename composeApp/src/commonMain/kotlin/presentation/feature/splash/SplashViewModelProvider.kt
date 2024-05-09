package presentation.feature.splash

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SplashViewModelProvider : KoinComponent {
    private val viewModel by inject<SplashViewModel>()
    fun provide() = viewModel
}
