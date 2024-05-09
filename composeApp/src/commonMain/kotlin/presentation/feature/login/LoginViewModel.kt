package presentation.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.network.requests.LoginRequest
import domain.usecase.GetUserFromPreferenceUseCase
import domain.usecase.LoginUseCase
import domain.usecase.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import presentation.model.toError

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val userUseCase: GetUserFromPreferenceUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(LoginScreenState())
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

            result.onSuccess {
                userUseCase.add(User(state.email.uppercase(), state.email))
            }

            _state.update {
                it.copy(
                    error = result.exceptionOrNull()?.toError()?.message,
                    isLoading = false,
                    isLoggedIn = result.isSuccess,
                )
            }
        }
    }
}
