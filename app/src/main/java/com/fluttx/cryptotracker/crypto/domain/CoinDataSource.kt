package com.fluttx.cryptotracker.crypto.domain

import com.fluttx.cryptotracker.core.domain.util.NetworkError
import com.fluttx.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}