package presentation.feature.login

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import domain.usecase.LoginUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : KMMViewModel(), KoinComponent {

    private val loginUseCase: LoginUseCase by inject()

    private val _state = MutableStateFlow(viewModelScope, LoginState())
    private val _stateLoading = MutableStateFlow(viewModelScope, false)

    @NativeCoroutinesState
    val state = _state.asStateFlow()

    @NativeCoroutinesState
    val stateLoading = _stateLoading.asStateFlow()
    private fun onEmailChange(value: String) {
        _state.update { state ->
            state.copy(email = value)
        }
    }

    private fun onPasswordChange(value: String) {
        _state.update { state ->
            state.copy(password = value)
        }
    }

    fun handleIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.Login -> login()
            is LoginIntent.OnEmailChange -> onEmailChange(intent.email)
            is LoginIntent.OnPasswordChange -> onPasswordChange(intent.pass)
        }
    }

    private fun login() {
        viewModelScope.coroutineScope.launch {
            _stateLoading.value = true
            val state = _state.value
            val result = loginUseCase(state.email, state.password)
            _state.update { state ->
                _stateLoading.value = false
                state.copy(
                    isLoading = false,
                    isLoggedIn = result.isSuccess,
                )
            }
        }
    }
}
