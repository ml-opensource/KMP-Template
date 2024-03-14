package data.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val id: Int,
    val token: String,
)
