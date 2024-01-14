package com.iandrobot.cryptoapp6.data.repository

import com.iandrobot.cryptoapp6.common.Resource
import com.iandrobot.cryptoapp6.data.network.CoinApi
import com.iandrobot.cryptoapp6.data.toCoin
import com.iandrobot.cryptoapp6.data.toCoinDetail
import com.iandrobot.cryptoapp6.domain.model.Coin
import com.iandrobot.cryptoapp6.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {
    override suspend fun getCoins(): Flow<Resource<List<Coin>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val data = api.getCoins().map { it.toCoin() }
                emit(Resource.Success(data))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "HttpException"))
            } catch (e: IOException) {
                emit(Resource.Error(e.localizedMessage ?: "IOException"))
            }
        }
    }

    override suspend fun getCoinById(coinId: String): Flow<Resource<CoinDetail>> {
        return flow {
            try {
                emit(Resource.Loading())
                val data = api.getCoinById(coinId).toCoinDetail()
                emit(Resource.Success(data))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "HttpException"))
            } catch (e: IOException) {
                emit(Resource.Error(e.localizedMessage ?: "IOException"))
            }
        }
    }
}