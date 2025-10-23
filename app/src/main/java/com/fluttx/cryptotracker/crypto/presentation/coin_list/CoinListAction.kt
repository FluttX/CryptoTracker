package com.fluttx.cryptotracker.crypto.presentation.coin_list

import com.fluttx.cryptotracker.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
}