package com.iandrobot.cryptoapp6.domain.use_case

import com.iandrobot.cryptoapp6.data.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke() = repository.getCoins()
}