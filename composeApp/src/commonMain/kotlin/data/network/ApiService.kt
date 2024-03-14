package data.network

import io.ktor.client.statement.HttpResponse

interface ApiService {
    suspend fun getProducts(limit: Int = 10, skip: Int = 0): HttpResponse

    suspend fun authenticate(userName: String, pass: String): HttpResponse
}
