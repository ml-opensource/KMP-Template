package data.network

import di.ApiErrorValidator
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

class ApiErrorInterceptor : ApiErrorValidator {
     override fun validateResponse(response: HttpResponse) {
         when (val statusCode = response.status) {
             HttpStatusCode.Forbidden -> throw ApiErrorException(statusCode, "Access denied")
             HttpStatusCode.BadRequest -> throw ApiErrorException(statusCode, "Bad request")
             HttpStatusCode.Unauthorized -> throw ApiErrorException(statusCode, "Unauthorized")
             HttpStatusCode.NotFound -> throw ApiErrorException(statusCode, "Resource not found")
             HttpStatusCode.InternalServerError -> throw ApiErrorException(statusCode, "Internal server error")
             HttpStatusCode.ServiceUnavailable -> throw ApiErrorException(statusCode, "Service unavailable")
             HttpStatusCode.RequestTimeout -> throw ApiErrorException(statusCode, "The request timed out")
            else -> {
                throw ApiErrorException(statusCode, "Unexpected status code: ${statusCode.value}")
            }
        }
    }
}