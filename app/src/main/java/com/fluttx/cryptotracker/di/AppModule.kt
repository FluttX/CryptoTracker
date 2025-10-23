package com.fluttx.cryptotracker.di

import com.fluttx.cryptotracker.core.data.networking.HttpClientFactory
import com.fluttx.cryptotracker.crypto.data.networking.RemoteCoinDataSource
import com.fluttx.cryptotracker.crypto.domain.CoinDataSource
import com.fluttx.cryptotracker.crypto.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}