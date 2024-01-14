package com.iandrobot.cryptoapp6.domain.model

data class CoinDetail(
    val description: String,
    val developmentStatus: String,
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val logo: String,
    val message: String,
    val name: String,
    val openSource: Boolean,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<String>,
    val type: String
)
