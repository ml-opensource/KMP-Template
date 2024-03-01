package data.network

import di.NetworkModule
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class ApiService(private val httpClient: HttpClient) {
    suspend fun getProducts(limit: Int = 10, skip: Int = 0): HttpResponse = httpClient.get(
        NetworkModule.PATH,
    ) {
        parameter(NetworkModule.PARAM_LIMIT, limit)
        parameter(NetworkModule.PARAM_SKIP, skip)
    }
}
