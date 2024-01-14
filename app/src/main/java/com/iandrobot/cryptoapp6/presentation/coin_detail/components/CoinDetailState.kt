package com.iandrobot.cryptoapp6.presentation.coin_detail.components

import com.iandrobot.cryptoapp6.domain.model.CoinDetail

data class CoinDetailState(
    val coinDetail: CoinDetail? = null,
    val loading: Boolean = false,
    val error: String = ""
)
