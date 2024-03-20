package domain.usecase

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach

class LoginUseCase(
    private val authRepository: AuthRepository,
) {
    @NativeCoroutines
    suspend operator fun invoke(email: String, password: String) = flow {
        emit(
            runCatching {
                authRepository.authenticate(email, password)
            }
        )
    }
}
