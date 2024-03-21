package data.network.errorhandling

import io.ktor.http.HttpStatusCode

class ApiErrorException(val statusCode: HttpStatusCode, override val message: String) : Exception(
    message,
)
