package domain.usecase

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import data.network.requests.LoginRequest
import domain.repository.AuthRepository
import kotlinx.coroutines.flow.flow

class LoginUseCase(
    private val authRepository: AuthRepository,
) {
    @NativeCoroutines
    suspend operator fun invoke(loginRequest: LoginRequest) = flow {
        emit(
            runCatching {
                authRepository.authenticate(loginRequest)
            },
        )
    }
}
