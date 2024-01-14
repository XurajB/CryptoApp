package com.iandrobot.cryptoapp6.domain.use_case

import com.iandrobot.cryptoapp6.data.repository.CoinRepository
import javax.inject.Inject

class GetCoinsByIdUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(coinId: String) = repository.getCoinById(coinId)
}