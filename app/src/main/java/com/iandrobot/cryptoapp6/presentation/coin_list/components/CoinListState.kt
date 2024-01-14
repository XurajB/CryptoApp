package com.iandrobot.cryptoapp6.presentation.coin_list.components

import com.iandrobot.cryptoapp6.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)