package presentation.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import data.network.requests.LoginRequest
import domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.model.toError
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(), KoinComponent {
    private val loginUseCase: LoginUseCase by inject()
    private val _state = MutableStateFlow(LoginState())

    @NativeCoroutinesState
    val state = _state.asStateFlow()

    fun handleIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.Login -> login()
            is LoginIntent.OnEmailChange -> onEmailChange(intent.email)
            is LoginIntent.OnPasswordChange -> onPasswordChange(intent.pass)
        }
    }

    private fun onEmailChange(value: String) = _state.update { it.copy(email = value) }

    private fun onPasswordChange(value: String) = _state.update { it.copy(password = value) }

    private fun login() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val state = _state.value
            val result = loginUseCase(LoginRequest(state.email, state.password))
            _state.update { state ->
                state.copy(
                    error = result.exceptionOrNull()?.toError()?.message,
                    isLoading = false,
                    isLoggedIn = result.isSuccess,
                )
            }
        }
    }
}
