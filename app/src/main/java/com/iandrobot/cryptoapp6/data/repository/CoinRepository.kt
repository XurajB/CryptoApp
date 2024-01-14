package com.iandrobot.cryptoapp6.data.repository

import com.iandrobot.cryptoapp6.common.Resource
import com.iandrobot.cryptoapp6.domain.model.Coin
import com.iandrobot.cryptoapp6.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    suspend fun getCoins(): Flow<Resource<List<Coin>>>
    suspend fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>
}