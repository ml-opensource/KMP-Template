package data

import data.network.ApiErrorException
import io.ktor.client.network.sockets.SocketTimeoutException

sealed interface ErrorModel {

    val message: String

    data class ApiError(val exception: ApiErrorException, override val message: String) : ErrorModel

    sealed class Connection : ErrorModel {
        data object Timeout : Connection() {
            override val message: String = "Connection timed out"
        }

        data object UnknownHost : Connection() {
            override val message: String = "Unknown host"
        }
    }

    data class Unknown(val throwable: Throwable, override val message: String) : ErrorModel
}

fun Throwable.toError(): ErrorModel {
    return when (this) {
        is ApiErrorException -> {
            ErrorModel.ApiError(this, "API error: ${this.message}")
        }

        is SocketTimeoutException -> ErrorModel.Connection.Timeout
        else -> ErrorModel.Unknown(this, "Unknown error: ${this.message}")
    }
}

