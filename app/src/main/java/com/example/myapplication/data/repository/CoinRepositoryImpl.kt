package com.example.myapplication.data.repository


import com.example.myapplication.data.remote.CoinPaprikaApi
import com.example.myapplication.data.remote.dto.CoinDetailsModel
import com.example.myapplication.data.remote.dto.CoinModel
import com.example.myapplication.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getTicker(asset: String ,nonce :String , apikey:String ): CoinDetailsModel {
        return api.getTicker(asset , nonce , apikey)
    }

    override suspend fun getCoinList(): CoinModel {
        return api.getCoinList()
    }



}