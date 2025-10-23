package com.fluttx.cryptotracker.core.domain.util

enum class NetworkError : Error {
    REQUEST_TIMEOUT,
    TO_MANY_REQUESTS,
    NO_INTERNET,
    SERVER_ERROR,
    SERIALIZATION_ERROR,
    UNKNOWN_ERROR,
}