package domain.repository

import data.model.AuthResponse

interface AuthRepository {
    suspend fun authenticate(email: String, password: String): AuthResponse
}
