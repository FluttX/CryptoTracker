package com.fluttx.cryptotracker.crypto.data.networking

import com.fluttx.cryptotracker.core.data.networking.constructUrl
import com.fluttx.cryptotracker.core.data.networking.safeCall
import com.fluttx.cryptotracker.core.domain.util.NetworkError
import com.fluttx.cryptotracker.core.domain.util.Result
import com.fluttx.cryptotracker.core.domain.util.map
import com.fluttx.cryptotracker.crypto.data.mappers.toCoin
import com.fluttx.cryptotracker.crypto.data.networking.dto.CoinResponseDto
import com.fluttx.cryptotracker.crypto.domain.Coin
import com.fluttx.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

}