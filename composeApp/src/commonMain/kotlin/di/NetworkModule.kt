package di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module
import kotlinx.serialization.json.Json

object NetworkModule {
    private const val BASE_URL = "dummyjson.com"

    val networkClient = module {
        single {
            HttpClient {
                defaultRequest {
                    url {
                        protocol = URLProtocol.HTTPS
                        host = BASE_URL
                    }
                    header(HttpHeaders.ContentType, ContentType.Application.Json)
                }
                install(Logging) {
                    logger = Logger.SIMPLE
                    level = LogLevel.ALL
                }
                install(ContentNegotiation) {
                    json(Json { isLenient = true; ignoreUnknownKeys = true })
                }
            }
        }
    }
}
