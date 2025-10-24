package com.fluttx.cryptotracker.crypto.presentation.coin_list

import com.fluttx.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}