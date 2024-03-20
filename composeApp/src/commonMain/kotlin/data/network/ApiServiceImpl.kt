package data.network

import data.network.ApiDefinition.ApiEndpoint.Login
import data.network.ApiDefinition.ApiEndpoint.Products
import data.network.ApiDefinition.ApiField.PARAM_LIMIT
import data.network.ApiDefinition.ApiField.PARAM_SKIP
import data.network.ApiDefinition.ApiField.password
import data.network.ApiDefinition.ApiField.username
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

class ApiServiceImpl(private val httpClient: HttpClient) : ApiService {
    override suspend fun getProducts(limit: Int, skip: Int): HttpResponse = httpClient.get(
        Products.path,
    ) {
        parameter(PARAM_LIMIT, limit)
        parameter(PARAM_SKIP, skip)
    }

    override suspend fun authenticate(userName: String, pass: String): HttpResponse =
        throw ApiErrorException(HttpStatusCode.BadRequest,"Bad ")

}
