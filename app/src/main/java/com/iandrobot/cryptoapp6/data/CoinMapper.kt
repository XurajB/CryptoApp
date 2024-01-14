package com.iandrobot.cryptoapp6.data

import com.iandrobot.cryptoapp6.data.network.dto.CoinDetailDto
import com.iandrobot.cryptoapp6.data.network.dto.CoinDto
import com.iandrobot.cryptoapp6.domain.model.Coin
import com.iandrobot.cryptoapp6.domain.model.CoinDetail

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        isNew = isNew,
        name = name,
        rank = rank,
        symbol = symbol,
        type = type
    )
}

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        description = description,
        developmentStatus = developmentStatus,
        id = id,
        isActive = isActive,
        isNew = isNew,
        logo = logo,
        message = message,
        name = name,
        openSource = openSource,
        rank = rank,
        symbol = symbol,
        tags = tags.map { it.name },
        team = team.map { it.name },
        type = type
    )
}