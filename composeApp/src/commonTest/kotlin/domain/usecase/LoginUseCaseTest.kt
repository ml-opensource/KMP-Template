package domain.usecase

import data.model.AuthResponse
import domain.repository.AuthRepository
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class LoginUseCaseTest {

    private lateinit var sut: LoginUseCase
    private val mockAuthRepository = object : AuthRepository {
        override suspend fun authenticate(email: String, password: String): AuthResponse {
            return AuthResponse(id = 0, token = "token")
        }
    }

    @BeforeTest
    fun setUp() {
        sut = LoginUseCase(mockAuthRepository)
    }

    @Test
    fun loginUseCase_ValidCredentials_ReturnsAuthResponse() = runTest {
        // Arrange
        val loginUseCase = LoginUseCase(mockAuthRepository)
        val userName = "test"
        val password = "password"
        val expectedResult = AuthResponse(id = 0, token = "token")


        // Act
        val result = loginUseCase(userName, password)

        // Assert
        result.collect { result ->
            assertEquals(expectedResult, result.getOrNull())
        }
    }
}
