package com.iandrobot.cryptoapp6.di

import com.iandrobot.cryptoapp6.common.Constants
import com.iandrobot.cryptoapp6.data.network.CoinApi
import com.iandrobot.cryptoapp6.data.repository.CoinRepository
import com.iandrobot.cryptoapp6.data.repository.CoinRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesCoinApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCoinRepository(api: CoinApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}