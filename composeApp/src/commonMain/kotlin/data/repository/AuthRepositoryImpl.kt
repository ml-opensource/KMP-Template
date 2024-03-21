package data.repository

import data.model.AuthResponse
import data.network.ApiService
import domain.repository.AuthRepository
import io.ktor.client.call.body

class AuthRepositoryImpl(private val apiService: ApiService) : AuthRepository {
    override suspend fun authenticate(email: String, password: String) =
        apiService.authenticate(email, password).body<AuthResponse>()
}
