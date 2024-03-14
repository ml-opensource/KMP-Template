package domain.usecase

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import domain.repository.AuthRepository

class LoginUseCase(
    private val authRepository: AuthRepository,
) {
    @NativeCoroutines
    suspend operator fun invoke(email: String, password: String) = runCatching {
        authRepository.authenticate(email, password)
    }
}
