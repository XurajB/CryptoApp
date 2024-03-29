package com.iandrobot.cryptoapp6.data.network

import com.iandrobot.cryptoapp6.data.network.dto.CoinDetailDto
import com.iandrobot.cryptoapp6.data.network.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}