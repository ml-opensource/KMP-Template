package presentation.feature.login

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginViewModelProvider : KoinComponent {
    private val viewModel by inject<LoginViewModel>()
    fun provide() = viewModel
}
