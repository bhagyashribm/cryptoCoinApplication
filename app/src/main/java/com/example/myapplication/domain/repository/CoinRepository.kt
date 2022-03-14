package com.example.myapplication.domain.repository

import com.example.myapplication.data.remote.dto.CoinDetailsModel
import com.example.myapplication.data.remote.dto.CoinModel


interface CoinRepository {

    suspend fun getTicker(asset: String ,nonce :String , apikey:String): CoinDetailsModel

    suspend fun getCoinList(): CoinModel
}