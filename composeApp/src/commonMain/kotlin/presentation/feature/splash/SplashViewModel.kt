package presentation.feature.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.usecase.GetUserFromPreferenceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SplashViewModel(
    private val userUseCase: GetUserFromPreferenceUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(SplashScreenState())
    val state = _state.asStateFlow()

    fun handleIntent(intent: SplashScreenIntent) {
        when (intent) {
            is SplashScreenIntent.OnContentVisibilityChange -> _state.update { it.copy(showContent = intent.show) }
        }
    }

    init {
        getUser()
    }

    private fun getUser() = viewModelScope.launch {
        _state.update { it.copy(user = userUseCase.get()) }
        println("USER | ${state.value.user}")
    }
}
