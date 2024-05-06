package domain.usecase

import data.network.requests.LoginRequest
import domain.repository.AuthRepository

class LoginUseCase(
    private val authRepository: AuthRepository,
) {

    suspend operator fun invoke(loginRequest: LoginRequest) = runCatching {
        authRepository.authenticate(loginRequest)
    }
}
